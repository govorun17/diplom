package my.diplom.dev.controller;

import lombok.AccessLevel;
import lombok.Setter;
import my.diplom.dev.dto.AuthDto;
import my.diplom.dev.dto.entity.User;
import my.diplom.dev.service.RoleService;
import my.diplom.dev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@Setter(value = AccessLevel.PRIVATE, onMethod = @__(@Autowired))
public class AuthController {

	private PasswordEncoder encoder;
	private RoleService roleService;
	private UserService userService;

	@GetMapping("/register")
	public ModelAndView registerPage(Map<String, Object> model) {
		return new ModelAndView("register", model);
	}

	@PostMapping(value = "/register")
	public ModelAndView register(
			AuthDto authDto,
			Map<String, Object> model
	) {
		if(!userService.isUserExistsByUsername(authDto.getName())) {
			User user = new User();
			user.setName(authDto.getName());
			user.setSurname(authDto.getSurname());
			user.setUsername(authDto.getUsername());
			user.setPassword(encoder.encode(authDto.getPassword()));
			user.setRole(roleService.findByName(RoleService.MODERATOR));
			userService.save(user);
			model.put("message", "Пользователь успешно создан");
			return new ModelAndView("login", model, HttpStatus.CREATED);
		} else {
			model.put("message", "Пользователь уже существует");
			return new ModelAndView("register", model, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/login")
	public ModelAndView loginErrorPage(
			Map<String, Object> model,
			@RequestParam(required = false) String error
	) {
		if(error != null) {
			model.put("message", "Неверный логин или пароль");
			return new ModelAndView("login", model, HttpStatus.BAD_REQUEST);
		}
		return new ModelAndView("login", model, HttpStatus.OK);
	}
}
