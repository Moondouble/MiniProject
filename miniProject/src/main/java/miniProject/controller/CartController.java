package miniProject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import miniProject.command.CartCommand;
import miniProject.service.cart.CartInsertService;
import miniProject.service.cart.CartListService;

@RestController
@RequestMapping("cart")
public class CartController {

	@Autowired
	private CartListService cartListService;

	/*
	 * @GetMapping("/wishList/{memberNum
	 * 
	 * @PostMapping("/add") public String addToCart(@RequestParam("goodsId") String
	 * goodsId,
	 * 
	 * @RequestParam("quantity") int quantity, HttpSession session) { CartCommand
	 * cartCommand = new CartCommand(); cartCommand.setGoodsId(goodsId);
	 * cartCommand.setQuantity(quantity); cartInsertService.insert(cartCommand,
	 * session); return "redirect:/cart/list"; }
	 * 
	 * }") public String memberDetail(@PathVariable("memberNum") String memberNum,
	 * Model model) { wishListService.execute(memberNum, model); return
	 * "thymeleaf/member/profile";
	 * 
	 * @PostMapping("/add") public String addToCart(@RequestParam("goodsId") String
	 * goodsId,
	 * 
	 * @RequestParam("quantity") int quantity, HttpSession session) { CartCommand
	 * cartCommand = new CartCommand(); cartCommand.setGoodsId(goodsId);
	 * cartCommand.setQuantity(quantity); cartInsertService.insert(cartCommand,
	 * session); return "redirect:/cart/list"; }
	 * 
	 * }
	 * 
	 * @GetMapping("/wishadd/{memberNum
	 * 
	 * @PostMapping("/add") public String addToCart(@RequestParam("goodsId") String
	 * goodsId,
	 * 
	 * @RequestParam("quantity") int quantity, HttpSession session) { CartCommand
	 * cartCommand = new CartCommand(); cartCommand.setGoodsId(goodsId);
	 * cartCommand.setQuantity(quantity); cartInsertService.insert(cartCommand,
	 * session); return "redirect:/cart/list"; }
	 * 
	 * }") public String add(@PathVariable("memberNum") String memberNum,
	 * 
	 * @PathVariable("goodsNum") String goodsNum, Model model) { return
	 * "redirect:/";
	 * 
	 * @PostMapping("/add") public String addToCart(@RequestParam("goodsId") String
	 * goodsId,
	 * 
	 * @RequestParam("quantity") int quantity, HttpSession session) { CartCommand
	 * cartCommand = new CartCommand(); cartCommand.setGoodsId(goodsId);
	 * cartCommand.setQuantity(quantity); cartInsertService.insert(cartCommand,
	 * session); return "redirect:/cart/list"; }
	 * 
	 * }
	 */

	@Autowired
	CartInsertService cartInsertService;

	/*
	 * @RequestMapping("cartAdd") public String cartAdd(@RequestBody CartCommand
	 * cartCommand, HttpSession session) {
	 * System.out.println(cartCommand.getGoodsNum()); return
	 * cartInsertService.execute(cartCommand, session); }
	 */
	@PostMapping("/add")
	public String addToCart(@RequestBody CartCommand cartCommand, HttpSession session) {
		try {
			cartInsertService.execute(cartCommand, session);
			return "장바구니에 성공적으로 추가되었습니다.";
		} catch (Exception e) {
			return "장바구니 추가 중 오류가 발생했습니다: " + e.getMessage();
		}
	}
	
	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity<String> addToCart(@RequestBody CartCommand cartCommand) {
	    try {
	        cartInsertService.execute(cartCommand);
	        return ResponseEntity.ok("상품이 장바구니에 추가되었습니다.");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("장바구니 추가 중 오류가 발생했습니다.");
	    }
	}
	
	/*
	 * @RequestMapping("cartList") public String cartList(Model model, HttpSession
	 * session) { cartListService.execute(model, session); return
	 * "thymeleaf/cart/cartList"; }
	 */
	

}
