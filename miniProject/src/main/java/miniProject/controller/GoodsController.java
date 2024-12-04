package miniProject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import miniProject.command.GoodsCommand;
import miniProject.service.AutoNumService;
import miniProject.service.goods.GoodsDetailService;
import miniProject.service.goods.GoodsListService;
import miniProject.service.goods.GoodsWriteService;
import miniProject.service.goods.MainGoodsListService;

@Controller
@RequestMapping("goods")
public class GoodsController {
	@Autowired
	AutoNumService autoNumService;
	@Autowired
	GoodsWriteService goodsWriteService;
	@Autowired
	GoodsListService goodsListService;
	@Autowired
	GoodsDetailService goodsDetailService;
	
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
	
	@Autowired
	MainGoodsListService mainGoodsListService;
	@GetMapping("goodsList")
	public String goodsList2(Model model) {
		mainGoodsListService.execute(model);
		return "thymeleaf/goods/goodsList";
	}
	
	@RequestMapping("goodsDetail")
	public String goodsDetail(@RequestParam("goodsNum") String goodsNum, Model model) {
		goodsDetailService.execute(goodsNum, model);
		return "thymeleaf/goods/goodsDetail";
	}
	
	/*
	 * @RequestMapping("../") public String goodsList(Model model){
	 * goodsListService.execute(null,model,1); return "redirect:../"; }
	 */
}
