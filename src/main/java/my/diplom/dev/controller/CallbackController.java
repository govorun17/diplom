package my.diplom.dev.controller;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import my.diplom.dev.dto.VkDto;
import my.diplom.dev.dto.JsonDto;
import my.diplom.dev.entity.Group;
import my.diplom.dev.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class CallbackController {
	// TODO: 13.01.2021 разобраться с конфигами спринга чтобы вынести проперти в json????
	private VkDto vkDto;
	private GroupService groupService;

	@Autowired
	private void setAutowired(
			VkDto vkDto,
			GroupService groupService
	) {
		this.vkDto = vkDto;
		this.groupService = groupService;
	}

	@GetMapping
	public ResponseEntity<Object> setKey(
			@RequestParam Long id,
			@RequestParam(required = false) String key,
			@RequestParam(required = false) String secret,
			@RequestParam(required = false) String token
	) {
		return new ResponseEntity<>(groupService.saveOrUpdate(id, key, secret, token), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> callback(@RequestBody JsonDto jsonDto) {
		Group group = groupService.findById(jsonDto.getGroupId());
		if(group == null) {
			return new ResponseEntity<>(String.format("Не найдена группа с id %d", jsonDto.getGroupId()), HttpStatus.BAD_REQUEST);
		}
		if(!jsonDto.getSecret().equals(group.getSecret())){
			return new ResponseEntity<>("NOPE!", HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(group.getCode(), HttpStatus.OK);
	}

	// TODO: 13.01.2021 совместить конфирмацию и колбэк
	@PostMapping("/callback")
	public ResponseEntity<String> callback(@RequestBody JsonNode json) {
		return new ResponseEntity<>("ok", HttpStatus.OK);
	}
}
