
package miniProject.service.wish;

import miniProject.domain.WishDTO;

import java.util.List;

public interface WishListService {
    boolean addWish(WishDTO wishDTO);
    boolean deleteWish(Long wishId);
    List<WishDTO> getWishesByUser(Long userId);
}
