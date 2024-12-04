package miniProject.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import miniProject.domain.GoodsDTO;
import miniProject.mapper.GoodsMapper;

@Service
public class GoodsDetailService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(Model model, String goodsNum) {
		GoodsDTO dto = goodsMapper.selectOne(goodsNum);
		model.addAttribute("memberCommand", dto);
		
	}
}
