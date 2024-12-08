package miniProject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import miniProject.domain.WishDTO;
import miniProject.service.wish.WishListService;

@Controller
@RequestMapping("wish")
public class WishController {

    @Autowired
    private WishListService wishListService;

    @GetMapping("wishList")
    public String list(Model model, WishDTO dto, HttpSession session) {
        if (model.getAttribute("memberNum") == null) {
            return "redirect:/Join/loginWindow";
        }

        // Populate the model with data from the wishlist service
        return "thymeleaf/wish/wishList";
    }
}
