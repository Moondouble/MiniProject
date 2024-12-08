package miniProject.service.cart;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import miniProject.domain.AuthInfoDTO;
import miniProject.domain.GoodsCartDTO;
import miniProject.mapper.CartMapper;
import miniProject.mapper.MemberMapper;

@Service
public class CartListService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	CartMapper cartMapper;
	public void execute(Model model, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		String memberNum = memberMapper.memberNumSelect(auth.getUserId());
		
		List<GoodsCartDTO> list = cartMapper.cartSelectList(memberNum, null);
		model.addAttribute("list", list);
		Integer totPri = 0;
		Integer totQty = 0;
		for( GoodsCartDTO dto  :  list) {
			totPri += dto.getGoodsDTO().getGoodsPrice() * dto.getCartDTO().getCartQty();
			totQty += dto.getCartDTO().getCartQty();
		}
		model.addAttribute("totPri", totPri);
		model.addAttribute("totQty", totQty);
	}
}
