package ShopingApp.repository;

import ShopingApp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    boolean existsByName(String name);

    @Query("SELECT c FROM Category c")
    List<Category> findAllByName(); // This is fine

}
