package com.src.swaggerspringboot;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.slack.api.bolt.App;
import com.slack.api.bolt.AppConfig;
import com.slack.api.bolt.socket_mode.SocketModeApp;
import com.slack.api.model.event.MessageEvent;

@Configuration
public class MyApp {
	
	@Autowired
	SlackApp slackApp;
	
	//@PostConstruct
	public void initServer(AppConfig config) {
		
		System.out.println("SlockBot Server is Running...");
		String botToken = "xoxb-2223272623701-2250287659856-AqJQUi57o6lIwbe6HEKKly5m";
		String appToken = "xapp-1-A026NGRKC02-5574485140465-4b81c78a0dd8f3312db5a0de76639726d2ce2ce48dee4b62ff483f9a8f6582d0";
		
		//App app = new App(AppConfig.builder().singleTeamBotToken(botToken).build());
		//App app = new App(loadSingleWorkspaceAppConfig().builder().singleTeamBotToken(botToken).build());
		App app = new App(loadOAuthConfig().builder().singleTeamBotToken(botToken).build());
		//App app = new App(slackApp.loadOAuthConfig().builder().singleTeamBotToken(botToken).build());
		//App app = new App(config);
		
		if (config.getClientId() != null) {
            app.asOAuthApp(true);
        }
		
		app.command("/meeting", (req, ctx) -> {
            return ctx.ack(r -> r.text("Thanks!"));
        });

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
	
	// If you would like to run this app for a single workspace,
    // enabling this Bean factory should work for you.
    public AppConfig loadSingleWorkspaceAppConfig() {
        return AppConfig.builder()
                .singleTeamBotToken("xoxb-2223272623701-2250287659856-AqJQUi57o6lIwbe6HEKKly5m")
                .signingSecret("1527fbc65613253825740062dcd8ba61")
                .build();
    }

    // If you would like to run this app for multiple workspaces,
    // enabling this Bean factory should work for you.
    public AppConfig loadOAuthConfig() {
        return AppConfig.builder()
                .singleTeamBotToken(null)
                .clientId("2223272623701.2226569658002")
                .clientSecret("66587b612400da337651e8eb9a94b285")
                .signingSecret("1527fbc65613253825740062dcd8ba61")
                .scope("app_mentions:read,channels:history,channels:read,chat:write")
                .oauthInstallPath("/slack/install")
                .oauthRedirectUriPath("/slack/oauth_redirect")
                .build();
    }
	
	public static void main(String[] args) throws Exception {
		// String botToken = System.getenv("SLACK_BOT_TOKEN");
		//String botToken = "xoxb-2223272623701-2250287659856-pWjnN0KxCRyIDtBW1GXkaxLm";
		String botToken = "xoxb-2223272623701-2250287659856-AqJQUi57o6lIwbe6HEKKly5m";

		// String appToken = System.getenv("SLACK_APP_TOKEN");
		//String appToken = "xapp-1-A026NGRKC02-2251789258464-8958cb4861a6573fec9dff5a695a10648bcced0a9e79a3eda5b46bcbaaaa96d7";
		String appToken = "xapp-1-A026NGRKC02-5574485140465-4b81c78a0dd8f3312db5a0de76639726d2ce2ce48dee4b62ff483f9a8f6582d0";

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