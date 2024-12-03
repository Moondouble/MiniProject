package miniProject.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import miniProject.domain.GoodsDTO;
import miniProject.mapper.GoodsMapper;

@Service
public class GoodsListService {
	@Autowired
	GoodsMapper goodsMapper;

	public void execute(Model model) {
		List<GoodsDTO> list = goodsMapper.goodsAllSelect();
	}
}
