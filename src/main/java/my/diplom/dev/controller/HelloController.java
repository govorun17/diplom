package my.diplom.dev.controller;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@RequestMapping("/")
@Setter(onMethod = @__(@Autowired))
public class HelloController {

	@GetMapping("/h")
	public ModelAndView index(Map<String, Object> model) {
		model.put("h1", "qwerty");
		return new ModelAndView("head", model);
	}
}
