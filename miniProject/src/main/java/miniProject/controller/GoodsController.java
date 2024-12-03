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

import miniProject.command.GoodsCommand;
import miniProject.service.AutoNumService;
import miniProject.service.goods.GoodsListService;
import miniProject.service.goods.GoodsWriteService;

@Controller
@RequestMapping("goods")
public class GoodsController {
	@Autowired
	AutoNumService autoNumService;
	@Autowired
	GoodsWriteService goodsWriteService;
	@Autowired
	GoodsListService goodsListService;
	
	@GetMapping("goodsForm")
	public String goodsForm(Model model) {
		String autoNum = autoNumService.execute("goods_", "goods_num", 7, "goods");
        GoodsCommand goodsCommand = new GoodsCommand();
        goodsCommand.setGoodsNum(autoNum);
        model.addAttribute("goodsCommand", goodsCommand);
		return "thymeleaf/goods/goodsForm";
	}
	
	@PostMapping("goodsWrite")
	public String goodsWrite(@Validated GoodsCommand goodsCommand, BindingResult result, HttpSession session) {
		goodsWriteService.execute(goodsCommand, session);
		return "redirect:../";
	}
	
	
}
