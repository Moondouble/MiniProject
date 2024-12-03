package miniProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import miniProject.domain.GoodsDTO;

@Mapper
public interface GoodsMapper {
	public void goodsInsert(GoodsDTO dto);
	public List<GoodsDTO> goodsAllSelect();
	public int goodsCount(String searchWord);
	public List<GoodsDTO> goodsSelectList(
			@Param("startRow") int startRow
			,@Param("endRow") int endRow);
}
