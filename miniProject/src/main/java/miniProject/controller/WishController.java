package miniProject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import miniProject.domain.WishDTO;
import miniProject.service.wish.WishListService;

@Controller
@RequestMapping("wish")
public class WishController {

    @Autowired
    private WishListService wishListService;

    @GetMapping("/wishList/{memberNum}")
    public String memberDetail(@PathVariable("memberNum") String memberNum, Model model) {
        wishListService.execute(memberNum, model);
        return "thymeleaf/member/profile";
    }
    @GetMapping("wishadd/{memberNum}")
    public String add(@PathVariable("memberNum") String memberNum,
    		@PathVariable("goodsNum") String goodsNum,Model model) {
    	return "/";
    }
}
