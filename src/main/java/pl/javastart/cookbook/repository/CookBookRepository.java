package pl.javastart.cookbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javastart.cookbook.entity.Recipe;

public interface CookBookRepository extends JpaRepository<Recipe, Long> {
}
