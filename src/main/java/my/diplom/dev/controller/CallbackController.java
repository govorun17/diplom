package my.diplom.dev.controller;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import my.diplom.dev.config.VkConfig;
import my.diplom.dev.dto.JsonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CallbackController {

	private VkConfig vkConfig;

	@Autowired
	private void setAutowired(VkConfig vkConfig) {
		this.vkConfig = vkConfig;
	}

	@PostMapping
	public ResponseEntity<String> confirmation(@RequestBody JsonDto jsonDto) {
		return new ResponseEntity<>(vkConfig.getResponseKey(), HttpStatus.OK);
	}

	@PostMapping("/callback")
	public ResponseEntity<String> callback(@RequestBody JsonNode json) {
		return new ResponseEntity<>("ok", HttpStatus.OK);
	}
}
