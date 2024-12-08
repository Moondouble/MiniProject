package miniProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import miniProject.domain.StartEndPageDTO;
import miniProject.domain.WishDTO;

@Mapper
public interface WishMapper
{
	public List<WishDTO> memberWishSelectAll(String memberNum);
}
