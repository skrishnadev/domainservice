package com.src.swaggerspringboot;

import com.slack.api.bolt.App;
import com.slack.api.bolt.AppConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SlackApp {
	
	// If you would like to run this app for a single workspace,
    // enabling this Bean factory should work for you.
    @Bean
    public AppConfig loadSingleWorkspaceAppConfig() {
        return AppConfig.builder()
                .singleTeamBotToken("xoxb-2223272623701-2250287659856-AqJQUi57o6lIwbe6HEKKly5m")
                .signingSecret("1527fbc65613253825740062dcd8ba61")
                .build();
    }

    // If you would like to run this app for multiple workspaces,
    // enabling this Bean factory should work for you.
    // @Bean
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
    
 
    @Bean
    public App initSlackApp(AppConfig config) {
        App app = new App(config);
        if (config.getClientId() != null) {
            app.asOAuthApp(true);
        }
        app.command("/meeting", (req, ctx) -> {
            return ctx.ack(r -> r.text("Thanks!"));
        });
        return app;
    }
	
	
	@Bean
	public App initSlackApp() {
		String botToken = "xoxb-2223272623701-2250287659856-pWjnN0KxCRyIDtBW1GXkaxLm";

		// String appToken = System.getenv("SLACK_APP_TOKEN");
		String appToken = "xapp-1-A026NGRKC02-2251789258464-8958cb4861a6573fec9dff5a695a10648bcced0a9e79a3eda5b46bcbaaaa96d7";

		App app = new App(AppConfig.builder().singleTeamBotToken(botToken).build());

		app.command("/hello", (req, ctx) -> {
			return ctx.ack("What's up?");
		});
		return app;
	}
}