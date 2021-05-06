package my.diplom.dev.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@RequestMapping("/words")
public class WordsController {
	@GetMapping("/")
	public ModelAndView wordsList(Map<String, Object> model) {
		return new ModelAndView("words", model);
	}
}
