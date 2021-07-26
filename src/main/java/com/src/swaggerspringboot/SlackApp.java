package com.src.swaggerspringboot;

import com.slack.api.bolt.App;
import com.slack.api.bolt.AppConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SlackApp {
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