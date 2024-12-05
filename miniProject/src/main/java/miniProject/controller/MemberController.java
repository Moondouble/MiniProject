package miniProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import miniProject.domain.MemberDTO;
import miniProject.service.goods.GoodsDetailService;
import miniProject.service.goods.MainGoodsListService;
import miniProject.service.member.MemberDetailService;


@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberDetailService memberDetailService;
    @Autowired
    MainGoodsListService mainGoodsListService;

    @GetMapping("/memberDetail/{memberNum}")
    public String memberDetail(@PathVariable("memberNum") String memberNum, Model model) {
        memberDetailService.execute(memberNum, model);
        return "thymeleaf/member/profile";
    }
}
