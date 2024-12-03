package miniProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import miniProject.domain.GoodsDTO;
import miniProject.domain.StartEndPageDTO;

@Mapper
public interface GoodsMapper {
<<<<<<< HEAD
	public void goodsInsert(GoodsDTO dto);
	public List<GoodsDTO> goodsAllSelect();
	public int goodsCount(String searchWord);
	public List<GoodsDTO> goodsSelectList(
			@Param("startRow") int startRow
			,@Param("endRow") int endRow);
=======
	public int goodsInsert(GoodsDTO dto);
	public List<GoodsDTO> allSelect(StartEndPageDTO sepDTO);
	public int goodsCount(String searchWord);
	public int productsDelete(@Param("products") String products[]);
	public GoodsDTO selectOne(String goodsNum);
	public int goodsUpdate(GoodsDTO dto);
	public int goodsDelete(String goodsNum);
	
	public List<GoodsDTO> goodsSelectList(
			@Param("startRow") int startRow
			,@Param("endRow") int endRow);

>>>>>>> branch 'main' of https://github.com/Moondouble/MiniProject.git
}
