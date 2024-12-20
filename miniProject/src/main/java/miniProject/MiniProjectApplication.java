package miniProject;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import miniProject.domain.AuthInfoDTO;
import miniProject.domain.GoodsDTO;
import miniProject.service.goods.GoodsListService;
import miniProject.service.goods.MainGoodsListService;
import miniProject.service.member.MemberDetailService;

@Controller
@SpringBootApplication
public class MiniProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniProjectApplication.class, args);
	}
	@Autowired
	GoodsListService goodsListService;
	@Autowired
	MemberDetailService memberDetailService;
	@GetMapping("/")
	public String index(HttpSession session, Model model) {
	    AuthInfoDTO authInfo = (AuthInfoDTO) session.getAttribute("auth");
	    goodsListService.execute(null,model,1);
	    if (authInfo != null) { 
	    	System.out.println("로그인 되었습니다.");
	        model.addAttribute("auth", authInfo);
	        goodsListService.execute(null,model,1);
	    }
	    return "thymeleaf/index";
	}
	
	@Autowired
	MainGoodsListService mainGoodsListService;
	@PostMapping("/")
	public ModelAndView index(int page, Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsonView");
		mainGoodsListService.execute(model);
		return mav;
	}
}
