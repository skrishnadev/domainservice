package com.src.swaggerspringboot;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;

import com.slack.api.bolt.App;
import com.slack.api.bolt.AppConfig;
import com.slack.api.bolt.socket_mode.SocketModeApp;
import com.slack.api.model.event.MessageEvent;

@Configuration
public class MyApp {

	@PostConstruct
	public void initServer() {
		String botToken = "xoxb-2223272623701-2250287659856-pWjnN0KxCRyIDtBW1GXkaxLm";
		String appToken = "xapp-1-A026NGRKC02-2251789258464-8958cb4861a6573fec9dff5a695a10648bcced0a9e79a3eda5b46bcbaaaa96d7";

		App app = new App(AppConfig.builder().singleTeamBotToken(botToken).build());

		app.event(MessageEvent.class, (payload, ctx) -> {
			MessageEvent event = payload.getEvent();

			if (event.getText().equalsIgnoreCase("hi")) {
				ctx.say("Hi Krishna!!!! how are you");
			} else if (event.getText().equalsIgnoreCase("hello")) {
				ctx.say("Hello Vishnu!!!! How are you");
			} else if (event.getText().equalsIgnoreCase("hey")) {
				ctx.say("Hey Suresh!!!! How are you");
			} else if (event.getText().equalsIgnoreCase("10")) {
				ctx.say("Hello Suresh!!!! This is Ten");
			} else

			if (event.getText().equalsIgnoreCase("20")) {
				ctx.say("Hello Suresh!!!! This is Twenty");
			} else

			if (event.getText().equalsIgnoreCase("30")) {
				ctx.say("Hello Suresh!!!! This is Thirty");
			} else if (event.getText().equalsIgnoreCase("40")) {
				ctx.say("Hello Suresh!!!! This is Forty");
			} else {
				ctx.say("Hello Suresh!!!! We are working for you:)");
			}

			return ctx.ack();
		});
		SocketModeApp socketModeApp;
		try {
			socketModeApp = new SocketModeApp(appToken, app);
			socketModeApp.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) throws Exception {
		// String botToken = System.getenv("SLACK_BOT_TOKEN");
		String botToken = "xoxb-2223272623701-2250287659856-pWjnN0KxCRyIDtBW1GXkaxLm";

		// String appToken = System.getenv("SLACK_APP_TOKEN");
		String appToken = "xapp-1-A026NGRKC02-2251789258464-8958cb4861a6573fec9dff5a695a10648bcced0a9e79a3eda5b46bcbaaaa96d7";

		App app = new App(AppConfig.builder().singleTeamBotToken(botToken).build());

		app.event(MessageEvent.class, (payload, ctx) -> {
			System.out.println("===================Payload=================>>> \n " + payload);
			MessageEvent event = payload.getEvent();

			if (event.getText().equalsIgnoreCase("hi")) {
				ctx.say("Hi Krishna!!!! how are you");
			} else if (event.getText().equalsIgnoreCase("hello")) {
				ctx.say("Hello Vishnu!!!! How are you");
			} else if (event.getText().equalsIgnoreCase("hey")) {
				ctx.say("Hey Suresh!!!! How are you");
			} else if (event.getText().equalsIgnoreCase("10")) {
				ctx.say("Hello Suresh!!!! This is Ten");
			} else

			if (event.getText().equalsIgnoreCase("20")) {
				ctx.say("Hello Suresh!!!! This is Twenty");
			} else

			if (event.getText().equalsIgnoreCase("30")) {
				ctx.say("Hello Suresh!!!! This is Thirty");
			} else if (event.getText().equalsIgnoreCase("40")) {
				ctx.say("Hello Suresh!!!! This is Forty");
			} else {
				ctx.say("Hello Suresh!!!! We are working for you:)");
			}

			return ctx.ack();
		});
		SocketModeApp socketModeApp = new SocketModeApp(appToken, app);
		socketModeApp.start();
	}
}