package miniProject.service.wish;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import miniProject.domain.WishDTO;
import miniProject.mapper.WishMapper;

@Service
public class WishListService {

    @Autowired
    WishMapper wishMapper;

    public void execute(String memberNum,Model model) {
        List<WishDTO> memberGoodsList = wishMapper.memberWishSelectAll(memberNum);
        model.addAttribute("memberGoodsList", memberGoodsList);
    }
}
