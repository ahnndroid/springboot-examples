package io.ahnndroid.springbootexamples.controller.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.ahnndroid.springbootexamples.entity.user.User;
import io.ahnndroid.springbootexamples.repository.user.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
 
	/**
	 * 회원가입 페이지 방문
	 * @return
	 */
	@GetMapping("/signup")
	public String signUp_form() {
		return "/user/signup_form";
	}
	
	/**
	 * 회원가입 처리
	 * @param user
	 * @return
	 */
	@PostMapping("/signup")
	public String signUp(User user) {
		System.out.println(user);
		userRepository.save(user);
		return "redirect:/users";
	}
	
	/**
	 * 사용자 목록 조회
	 * @param model
	 * @return
	 */
	@GetMapping("")
	public String getUsers(Model model) {
		List<User> users = userRepository.findAll();
		model.addAttribute("users", users);
		return "/user/list";
	}
	
	/**
	 * 개별 사용자 정보 수정 페이지 방문
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/{id}")
	public String updateUserInfo_form(@PathVariable Long id, Model model) {
		Optional<User> user = userRepository.findById(id);
		model.addAttribute("user", user.get());
		return "/user/update_userinfo_form";
	}
	
	/**
	 * 개별 사용자 정보 수정 처리
	 * @param id
	 * @param model
	 * @return
	 */
	@PutMapping("/{id}")
	public String updateUserInfo(@PathVariable Long id, User updateUserInfo, Model model) {
		System.out.println(updateUserInfo);
		
		if (!id.equals(updateUserInfo.getId())) {
			throw new RuntimeException();
		}
		
		userRepository.save(updateUserInfo);
		
		return "redirect:/users";
	}
	
}