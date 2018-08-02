package io.ahnndroid.springbootexamples.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/")
	public String index(String name, Model model) {
		return getIndex(name, model);
	}
	
	@GetMapping("/index*")
	public String index2(String name, Model model) {
		return getIndex(name, model);
	}
	
	private String getIndex(String name, Model model) {
		if (StringUtils.isEmpty(name)) {
			name = "Anonymous";
		}
		
		model.addAttribute("name", name);
		return "index";
	}
}
