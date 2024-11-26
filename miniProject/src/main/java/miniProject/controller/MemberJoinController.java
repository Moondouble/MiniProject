package miniProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import miniProject.command.MemberCommand;
import miniProject.service.MemberInsertService;

@Controller
public class MemberJoinController {
	@Autowired
	MemberInsertService memberInsertService;
	
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
	
	@PostMapping("Join/userWrite")
	public String userWrite(MemberCommand memberCommand) {
		if (!memberCommand.isMemberPwEqualMemberPwCon()){
			 System.out.println("비밀번호 확인이 다릅니다.");
			 return "thymeleaf/member/memberForm"; 
		}
		memberInsertService.execute(memberCommand);
		return "redirect:../login/loginWindow";
	}
	
}
