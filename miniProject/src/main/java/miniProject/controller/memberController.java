package miniProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class memberController
{
	@GetMapping("profile")
	public String profile() {
		return "thymeleaf/member/Profile";
	}
	@GetMapping("profileUpdate")
	public String update() {
		return "#";
	}
}
