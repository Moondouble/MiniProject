package miniProject;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestMapping;
=======
import org.springframework.web.bind.annotation.GetMapping;

import miniProject.domain.AuthInfoDTO;
>>>>>>> branch 'main' of https://github.com/Moondouble/MiniProject.git

import miniProject.domain.AuthInfoDTO;

@Controller
@SpringBootApplication
public class MiniProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniProjectApplication.class, args);
	}
<<<<<<< HEAD

	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		AuthInfoDTO authInfo = (AuthInfoDTO) session.getAttribute("auth");
		if (authInfo != null) {
			System.out.println("로그인 되었습니다.");
			model.addAttribute("auth", authInfo);
		}
		return "thymeleaf/index";
=======
	@GetMapping("/")
	public String index(HttpSession session, Model model) {
	    AuthInfoDTO authInfo = (AuthInfoDTO) session.getAttribute("auth");
	    if (authInfo != null) {
	    	System.out.println("로그인 되었습니다.");
	        model.addAttribute("auth", authInfo);
	    }
	    return "thymeleaf/index";
>>>>>>> branch 'main' of https://github.com/Moondouble/MiniProject.git
	}
}
