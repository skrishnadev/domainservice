package com.src.swaggerspringboot;

import com.slack.api.Slack;
import com.slack.api.socket_mode.SocketModeClient;
import com.slack.api.socket_mode.request.EventsApiEnvelope;
import com.slack.api.socket_mode.response.AckResponse;
import com.slack.api.socket_mode.response.SocketModeResponse;

public class MyListener {

	public static void main(String[] args) {

		String appLevelToken = "xapp-1-A026NGRKC02-2251789258464-8958cb4861a6573fec9dff5a695a10648bcced0a9e79a3eda5b46bcbaaaa96d7";

		// Issue a new WSS URL and set the value to the client
		try (SocketModeClient client = Slack.getInstance().socketMode(appLevelToken)) {
			// SocketModeClient has #close() method

			// Add a listener function to handle all raw WebSocket text messages
			// You can handle not only envelopes but also any others such as "hello"
			// messages.
			client.addWebSocketMessageListener((String message) -> {
				// TODO: Do something with the raw WebSocket text message
				
				System.out.println("Message  " +message);
			});

			client.addWebSocketErrorListener((Throwable reason) -> {
				// TODO: Do something with a thrown exception
				System.out.println("reason  " +reason);
			});

			// Add a listener function that handles only type: events envelopes
			client.addEventsApiEnvelopeListener((EventsApiEnvelope envelope) -> {
				// TODO: Do something with an Events API payload
				System.out.println("Payload  " +envelope.getPayload());
				// Acknowledge the request (within 3 seconds)
				SocketModeResponse ack = AckResponse.builder().envelopeId(envelope.getEnvelopeId()).build();
				client.sendSocketModeResponse(ack);
			});

			client.connect(); // Start receiving messages from the Socket Mode server

			//client.disconnect(); // Disconnect from the server

			//client.connectToNewEndpoint(); // Issue a new WSS URL and connects to the URL
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
