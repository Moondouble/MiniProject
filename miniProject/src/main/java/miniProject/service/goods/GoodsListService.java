package miniProject.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import miniProject.domain.GoodsDTO;
import miniProject.domain.StartEndPageDTO;
import miniProject.mapper.GoodsMapper;
import miniProject.service.StartEndPageService;

@Service
public class GoodsListService {
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	StartEndPageService startEndPageService;
	String searchWord;
	public void execute(String searchWord , Model model, int page) {
		// 한페이지에 보일 list
		int limit = 3;
		StartEndPageDTO sepDTO = startEndPageService.execute(page,limit, searchWord);
		
		List<GoodsDTO> list = goodsMapper.allSelect(sepDTO);
		int count = goodsMapper.goodsCount(searchWord);
		// 페이징
		startEndPageService.execute(page,limit, count, searchWord,list, model);
	}
}

