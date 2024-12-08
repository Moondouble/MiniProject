package miniProject.mapper;

import java.util.List;

import miniProject.domain.StartEndPageDTO;
import miniProject.domain.WishDTO;

public interface WishMapper
{
	public List<WishDTO> memberWishSelectList(String memberNum);
}
