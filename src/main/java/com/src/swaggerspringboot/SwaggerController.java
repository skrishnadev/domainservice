package com.src.swaggerspringboot;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@RestController
@EnableAutoConfiguration
@Slf4j
@RequestMapping("/apps")
public class SwaggerController {

	@GetMapping("/test")
	public String getProcess() {
		return "SUCCESS";
	}

	@GetMapping
	public String execute() {
		return "Server is Running.....";
	}

	@PostMapping(value = "/slack/events", produces = MediaType.APPLICATION_JSON_VALUE)
	public String challenge(@RequestBody String data) throws Exception {
		JSONObject inputJSON = new JSONObject(data);
		String response = null;
		String challenge = (String) inputJSON.get("challenge");
		String type = (String) inputJSON.get("type");
		Gson gson = new Gson();
		if (type.equals("url_verification")) {
			Map<String, String> payload = new HashMap<>();
			payload.put("challenge", challenge);
			response = gson.toJson(payload);
			log.info(response);
			// responseJSON.put("challenge", challenge);
		} else {
			log.debug("Invalid input");
		}
		return response;
	}

	@Autowired
	private AppService appService;

	@PostMapping("/{message}")
	public ResponseEntity<String> sendSimpleMessageToSlack(@PathVariable(name = "message") String message) {
		appService.sendMessageToSlack(message);
		return ResponseEntity.ok(message);
	}

}
