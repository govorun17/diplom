package my.diplom.dev.controller;

import lombok.Setter;
import my.diplom.dev.dto.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@Setter(onMethod = @__(@Autowired))
public class AuthController {

	@GetMapping("/register")
	public ModelAndView registerPage(Map<String, Object> model) {
		return new ModelAndView("register", model);
	}

	@PostMapping(value = "/register")
	public ModelAndView register(
			Auth auth,
			Map<String, Object> model
	) {
		System.out.println(auth.getEmail() + " " + auth.getPassword() + " " + auth.getPasswordRepeat());
		return new ModelAndView("register", model);
	}
}
