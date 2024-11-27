package miniProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import miniProject.command.MemberCommand;
import miniProject.service.AutoNumService;
import miniProject.service.member.MemberInsertService;

@Controller
public class MemberJoinController {
	@Autowired
	MemberInsertService memberInsertService;
	@Autowired
	AutoNumService autoNumService;
	@Autowired
	MemberWriteService memberWriteService;
	
	@RequestMapping("login/loginWindow")
	public String loginWindow() {
		return "thymeleaf/login/loginWindow";
	}
	
	@RequestMapping("Join/tos")
	public String tos() {
		return "thymeleaf/Join/tos";
	}
	
//	@RequestMapping("Join/register")
//	public String register() {
//		return "thymeleaf/Join/register";
//	}
	@GetMapping("Join/write")
	public String register(Model model) {
		String autoNum = autoNumService.execute("mem_", "member_num", 5, "members");
		MemberCommand memberCommand = new MemberCommand();
		memberCommand.setMemberNum(autoNum);
		model.addAttribute("memberCommand", memberCommand);
		return "thymeleaf/Join/register";
	}
	@PostMapping("memberRegist")
	public String write(@Validated MemberCommand memberCommand
			,BindingResult result
			/*, Model model*/) {
		if(result.hasErrors()) {
			return "thymeleaf/Join/register";
		}
		if(!memberCommand.isMemberPwEqualMemberPwCon()) {
			//model.addAttribute("errPw","비밀번호가 일치하지 않아요. ");
			result.rejectValue("memberPwCon", "memberCommand.memberPwCon"
					, "비밀번호가 일치 하지 않습니다.");
			return "thymeleaf/Join/register";
		}
		memberWriteService.execute(memberCommand);
		return "thymeleaf/Join/welcome";
	}

	
	
}
