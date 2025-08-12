package az.edu.itbrains.job.repositories;

import az.edu.itbrains.job.models.Category;
import az.edu.itbrains.job.models.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findFirst3ByOrderByIdDesc();

    List<Category> findByFeaturedTrue();
}
