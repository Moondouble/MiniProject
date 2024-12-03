package miniProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import miniProject.service.member.MemberDetailService;

@Controller
@RequestMapping("/member")
public class memberController
{
	@Autowired
	MemberDetailService memberDetailService;
	
	@GetMapping("profile/{memberNum}")
	public String profile(@PathVariable("memberNum") String memberNum
			,Model model) {
	memberDetailService.execute(model, memberNum);
	return "thymeleaf/member/profile";
	}
	
	@GetMapping("profileUpdate")
	public String update() {
		return "#";
	}
}
