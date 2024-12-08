package miniProject.service.goods;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.fasterxml.jackson.databind.ObjectMapper;

import miniProject.domain.AuthInfoDTO;
import miniProject.domain.GoodsDTO;
import miniProject.domain.GoodsStockDTO;
import miniProject.mapper.GoodsMapper;
import miniProject.mapper.GoodsStockMapper;
import miniProject.mapper.ItemMapper;
import miniProject.mapper.MemberMapper;

@Service
public class GoodsDetailViewService {
	@Autowired
	GoodsStockMapper goodsStockMapper;
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	ItemMapper itemMapper;
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(String goodsNum, Model model, HttpServletResponse response
			, HttpSession session) {
		GoodsDTO dto1 = goodsMapper.goodsSelectOne(goodsNum);
		model.addAttribute("goodsCommand", dto1);
		model.addAttribute("newLine", "\n");
		
		
		GoodsStockDTO dto = goodsStockMapper.goodsStockSelectOne(goodsNum);
		goodsStockMapper.goodsVisitCountUpdate(goodsNum);
		model.addAttribute("dto", dto);
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		if(auth != null) {
			String memberNum =  memberMapper.memberNumSelect(auth.getUserId());
			Map<String, String> map = new HashMap<String, String>();
			map.put("goodsNum", goodsNum);
			map.put("memberNum", memberNum);
			Integer i = itemMapper.wishCountSelectOne(map);
			model.addAttribute("wish", i);
		}
		ObjectMapper mapper = new ObjectMapper();
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		try {
			response.getWriter().print(mapper.writeValueAsString(dto));
		}catch(Exception e) {}
	}
}
