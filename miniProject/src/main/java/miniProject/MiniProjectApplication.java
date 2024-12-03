package miniProject;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import miniProject.domain.AuthInfoDTO;

@Controller
@SpringBootApplication
public class MiniProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniProjectApplication.class, args);
	}

	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		AuthInfoDTO authInfo = (AuthInfoDTO) session.getAttribute("auth");
		if (authInfo != null) {
			System.out.println("로그인 되었습니다.");
			model.addAttribute("auth", authInfo);
		}
		return "thymeleaf/index";
	}

}
