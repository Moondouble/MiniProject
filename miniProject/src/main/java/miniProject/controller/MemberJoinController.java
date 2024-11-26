package miniProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class MemberJoinController {
	@RequestMapping("loginWindow")
	public String loginWindow() {
		return "thymeleaf/login/loginWindow";
	}
}
