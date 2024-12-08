package miniProject.service.wish;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import miniProject.domain.WishDTO;
import miniProject.mapper.WishMapper;

@Service
public class WishListService
{
	@Autowired
	WishMapper wishMapper;
	public void execute(Model model,WishDTO dto) {
		List<WishDTO> memberGoodsList = WishMapper.memberWishSelectAll(memberNum);
        model.addAttribute("memberGoodsList", memberGoodsList);
	}
}
