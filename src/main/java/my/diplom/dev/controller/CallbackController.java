package my.diplom.dev.controller;

import lombok.extern.slf4j.Slf4j;
import my.diplom.dev.dto.Events;
import my.diplom.dev.dto.JsonDto;
import my.diplom.dev.dto.VkDto;
import my.diplom.dev.entity.Group;
import my.diplom.dev.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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

	/**
	 * создает новую группу в базе для работы бота
	 * @param id id группы
	 * @param key ключ подтверждения
	 * @param secret секретный ключ
	 * @param token токен ключа доступа
	 * @return возвращает информацию для проверки
	 */
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
	public ResponseEntity<String> callback(
			@RequestBody JsonDto jsonDto,
			HttpServletRequest request
	) {
		Group group = groupService.findById(jsonDto.getGroupId());

		if(!groupService.validateGroup(group, jsonDto.getSecret())) {
			return new ResponseEntity<>(Events.OK.label(), HttpStatus.OK);
		}

		if(Events.CONFIRMATION.label().equals(jsonDto.getType())) {
			return new ResponseEntity<>(group.getCode(), HttpStatus.OK);
		}
		else if(Events.MESSAGE.label().equals(jsonDto.getType())) {

		}
		else if(Events.EVENT.label().equals(jsonDto.getType())){

		}
		else {
			return new ResponseEntity<>(Events.OK.label(), HttpStatus.OK);
		}
		return ResponseEntity.ok(Events.OK.label());
	}
}
