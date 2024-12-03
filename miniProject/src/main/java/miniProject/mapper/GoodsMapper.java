package miniProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import miniProject.domain.GoodsDTO;

@Mapper
public interface GoodsMapper {
	public void goodsInsert(GoodsDTO dto);
	public List<GoodsDTO> goodsSelectList();
}
