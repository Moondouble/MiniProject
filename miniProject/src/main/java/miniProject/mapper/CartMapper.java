package miniProject.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import miniProject.domain.CartDTO;
import miniProject.domain.GoodsCartDTO;
import miniProject.domain.GoodsDTO;

@Mapper
public interface CartMapper {
	public void cartMerge(CartDTO dto);
	public void cartInsert(CartDTO dto);
	public GoodsDTO goodsSelect(String goodsNum);
	public CartDTO cartSelect(Integer cartNum);
	public List<GoodsCartDTO> cartSelectList(
			  @Param("memberNum") String memberNum
			, @Param("nums") String[] nums);
	public int cartQtyDown(
			  @Param("goodsNum") String goodsNum
			, @Param("memberNum") String memberNum);
	public int goodsNumsDelete(Map<String, Object> condition);
}
