package miniProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberJoinController {
	@RequestMapping("login/loginWindow")
	public String loginWindow() {
		return "thymeleaf/login/loginWindow";
	}
	
	@RequestMapping("Join/tos")
	public String tos() {
		return "thymeleaf/Join/tos";
	}
	
	@RequestMapping("Join/register")
	public String register() {
		return "thymeleaf/Join/register";
	}
	
}
