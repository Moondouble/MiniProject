package miniProject.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import miniProject.domain.GoodsDTO;
import miniProject.mapper.GoodsMapper;
@Service
public class MemberGoodsListService
{
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(String memberNum,Model model) {
		List<GoodsDTO> list = goodsMapper.memberGoodsSelectAll(memberNum);
		model.addAttribute("list", list);
	}
}
