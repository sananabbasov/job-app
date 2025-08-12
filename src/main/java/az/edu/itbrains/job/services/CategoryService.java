package az.edu.itbrains.job.services;

import az.edu.itbrains.job.dtos.category.CategoryDto;
import az.edu.itbrains.job.dtos.category.CategoryHomeFeaturedDto;
import az.edu.itbrains.job.models.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryHomeFeaturedDto> getHomeFeaturedCategories();

    List<CategoryDto> getVacanciesCategories();

    Category findCategoryById(Long categoryId);
}
