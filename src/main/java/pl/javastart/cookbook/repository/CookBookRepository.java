package pl.javastart.cookbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javastart.cookbook.entity.Recipe;

import javax.transaction.Transactional;

public interface CookBookRepository extends JpaRepository<Recipe, Long> {
    @Transactional
    void deleteById(long id);
}
