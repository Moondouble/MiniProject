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

    public void execute(String goodsNum, Model model, HttpServletResponse response, HttpSession session) {
        // 상품 상세 정보 가져오기
        GoodsDTO dto1 = goodsMapper.goodsSelectOne(goodsNum);
        model.addAttribute("goodsCommand", dto1);
        model.addAttribute("newLine", "\n");

        // 상품 재고 정보 및 방문 수 증가
        GoodsStockDTO dto = goodsStockMapper.goodsStockSelectOne(goodsNum);
        goodsStockMapper.goodsVisitCountUpdate(goodsNum);
        model.addAttribute("dto", dto);

        // 사용자 인증 정보 확인
        AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
        if (auth == null) {
            System.out.println("세션에서 auth 정보를 가져오지 못했습니다.");
            return;
        }
        String userId = auth.getUserId();
        if (userId == null || userId.isEmpty()) {
            System.out.println("auth 객체의 userId가 null이거나 빈 값입니다.");
            return;
        }

        // 회원 번호 가져오기
        String memberNum = memberMapper.memberNumSelect(userId);
        if (memberNum == null) {
            System.out.println("해당 userId에 대한 memberNum이 없습니다: " + userId);
        } else {
            // 위시리스트 카운트 확인
            Map<String, String> map = new HashMap<>();
            map.put("goodsNum", goodsNum);
            map.put("memberNum", memberNum);

            Integer wishCount = itemMapper.wishCountSelectOne(map);
            model.addAttribute("wish", wishCount);
        }

        // JSON 응답 처리
        ObjectMapper mapper = new ObjectMapper();
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        try {
            //response.getWriter().print(mapper.writeValueAsString(dto));
        } catch (Exception e) {
            e.printStackTrace();
            //response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
