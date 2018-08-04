package io.ahnndroid.springbootexamples.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "/home/index";
	}
	
	@GetMapping("/index*")
	public String index() {
		return "/home/index";
	}
	
}