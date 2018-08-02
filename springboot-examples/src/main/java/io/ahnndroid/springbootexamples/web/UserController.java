package io.ahnndroid.springbootexamples.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.ahnndroid.springbootexamples.domain.User;
import io.ahnndroid.springbootexamples.domain.UserRepository;

@Controller
public class UserController {
	
	private List<User> users = new ArrayList<User>();
	
	@Autowired
	private UserRepository userRepository;

	@PostMapping("/user/create")
	public String create(User user, Model model) {
		System.out.println(user);
		userRepository.save(user);
		return "redirect:/user/list";
	}
	
	@GetMapping("/user/list")
	public String list(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "/user/list";
	}
	
}
