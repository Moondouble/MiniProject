
package miniProject.mapper;

import miniProject.domain.WishDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WishMapper {
    int insertWish(WishDTO wishDTO);
    int deleteWish(Long wishId);
    List<WishDTO> selectWishesByUser(Long userId);
}
