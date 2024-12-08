
package miniProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import miniProject.domain.WishDTO;
import miniProject.service.wish.WishListService;

import java.util.List;

@RestController
@RequestMapping("/api/wish")
public class WishController {

    @Autowired
    private WishListService wishListService;

    // Add a new wish
    @PostMapping
    public String addWish(@RequestBody WishDTO wishDTO) {
        boolean isAdded = wishListService.addWish(wishDTO);
        return isAdded ? "Wish added successfully!" : "Failed to add wish.";
    }

    // Delete a wish by ID
    @DeleteMapping("/{wishId}")
    public String deleteWish(@PathVariable Long wishId) {
        boolean isDeleted = wishListService.deleteWish(wishId);
        return isDeleted ? "Wish deleted successfully!" : "Failed to delete wish.";
    }

    // Get all wishes for a specific user
    @GetMapping("/{userId}")
    public List<WishDTO> getWishesByUser(@PathVariable Long userId) {
        return wishListService.getWishesByUser(userId);
    }
}
