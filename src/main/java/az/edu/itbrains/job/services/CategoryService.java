package az.edu.itbrains.job.services;

import az.edu.itbrains.job.dtos.category.CategoryHomeFeaturedDto;

import java.util.List;

public interface CategoryService {
    List<CategoryHomeFeaturedDto> getHomeFeaturedCategories();
}
