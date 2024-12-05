package miniProject.service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import miniProject.domain.GoodsDTO;
import miniProject.domain.MemberDTO;
import miniProject.mapper.GoodsMapper;
import miniProject.mapper.MemberMapper;

@Service
public class MemberDetailService {
    @Autowired
    MemberMapper memberMapper;
    @Autowired
    GoodsMapper goodsMapper;

    public void execute(String memberNum, Model model) {
        MemberDTO dto = memberMapper.memberSelectOne(memberNum);
        model.addAttribute("memberCommand", dto);
        
        List<GoodsDTO> memberGoodsList = goodsMapper.memberGoodsSelectAll(memberNum);
        model.addAttribute("memberGoodsList", memberGoodsList);
    }
}

