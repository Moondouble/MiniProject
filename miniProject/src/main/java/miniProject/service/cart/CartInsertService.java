package miniProject.service.cart;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import miniProject.command.CartCommand;
import miniProject.domain.AuthInfoDTO;
import miniProject.domain.CartDTO;
import miniProject.mapper.CartMapper;
import miniProject.mapper.MemberMapper;

@Service
public class CartInsertService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	CartMapper cartMapper;
	public String execute(CartCommand cartCommand, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		String memberNum = null;
		try {
			memberNum = memberMapper.memberNumSelect(auth.getUserId());
		}catch(Exception e) {
			e.printStackTrace();
			return "000";  // session이 없다
		}
		if(memberNum == null) {
			return "900";
		}else {
			CartDTO dto = new CartDTO();
			dto.setCartQty(cartCommand.getQty());
			dto.setGoodsNum(cartCommand.getGoodsNum());
			dto.setMemberNum(memberNum);
			cartMapper.cartMerge(dto);
			//cartMapper.cartInsert(dto);
			return "200";
		}
		
	}
}
