package pl.javastart.cookbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import pl.javastart.cookbook.entity.Recipe;

import javax.transaction.Transactional;
import java.util.List;

public interface CookBookRepository extends JpaRepository<Recipe, Long> {
    @Transactional
    void deleteById(long id);

    @Transactional
    List<Recipe> findAllByTitleContainsIgnoreCase(@Param("title")String title);


}
