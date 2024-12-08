
package miniProject.service.wish;

import miniProject.domain.WishDTO;
import miniProject.mapper.WishMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListServiceImpl implements WishListService {

    @Autowired
    private WishMapper wishMapper;

    @Override
    public boolean addWish(WishDTO wishDTO) {
        return wishMapper.insertWish(wishDTO) > 0;
    }

    @Override
    public boolean deleteWish(Long wishId) {
        return wishMapper.deleteWish(wishId) > 0;
    }

    @Override
    public List<WishDTO> getWishesByUser(Long userId) {
        return wishMapper.selectWishesByUser(userId);
    }
}
