package miniProject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import miniProject.command.LoginCommand;
import miniProject.command.MemberCommand;
import miniProject.service.AutoNumService;
import miniProject.service.IdcheckService;
import miniProject.service.UserLoginService;
import miniProject.service.member.MemberInsertService;

@Controller
@RequestMapping("/Join")
public class MemberJoinController {
    @Autowired
    MemberInsertService memberInsertService;
    @Autowired
    AutoNumService autoNumService;
    @Autowired
    IdcheckService idcheckService;
    @Autowired
    UserLoginService userLoginService;

    @RequestMapping("loginWindow")
    public String loginWindow(HttpSession session) {
        return "thymeleaf/Join/loginWindow";
    }
    
    @RequestMapping("tos")
    public String tos() {
        return "thymeleaf/Join/tos";
    }
    
    @GetMapping("write")
    public String register(Model model) {
        String autoNum = autoNumService.execute("mem_", "member_num", 5, "members");
        MemberCommand memberCommand = new MemberCommand();
        memberCommand.setMemberNum(autoNum);
        model.addAttribute("memberCommand", memberCommand);
        return "thymeleaf/Join/register";
    }
    
    @PostMapping("memberWrite")
    public String write(@Validated MemberCommand memberCommand, BindingResult result) {
        if (result.hasErrors()) {
            return "thymeleaf/Join/register";
        }
        if (!memberCommand.isMemberPwEqualMemberPwCon()) {
            result.rejectValue("memberPwCon", "memberCommand.memberPwCon", "비밀번호가 일치하지 않습니다.");
            return "thymeleaf/Join/register";
        }
        memberInsertService.execute(memberCommand);
        return "thymeleaf/Join/welcome";
    }

    @PostMapping("userIdCheck")
	public @ResponseBody Integer userIdCheck(String userId) {
		// html, jsp파일경로(x)
		return idcheckService.execute(userId);
		
	}
	@PostMapping("login")
	public String login(@Validated LoginCommand loginCommand
			,BindingResult result
			,HttpSession session) {
		userLoginService.execute(loginCommand, session, result);
		if(result.hasErrors()) {
			return "redirect:/";
		}
		return "redirect:/";
	}
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
