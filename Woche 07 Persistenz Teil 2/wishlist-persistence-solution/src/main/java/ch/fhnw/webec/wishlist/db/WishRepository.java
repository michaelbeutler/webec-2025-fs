package ch.fhnw.webec.wishlist.db;

import ch.fhnw.webec.wishlist.model.Category;
import ch.fhnw.webec.wishlist.model.Wish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishRepository extends JpaRepository<Wish, Integer> {

    // First try, too complicated:
    // @Query(value = "SELECT COUNT(*) FROM WISH_CATEGORIES  WHERE CATEGORIES_ID = ?1", nativeQuery = true)
    // int countWishesForCategory(int categoryId);

    // Much simpler (but more magic)
    long countByCategoriesContaining(Category category);

}
