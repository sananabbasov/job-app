package az.edu.itbrains.job.services.impls;

import az.edu.itbrains.job.dtos.category.CategoryHomeFeaturedDto;
import az.edu.itbrains.job.models.Category;
import az.edu.itbrains.job.repositories.CategoryRepository;
import az.edu.itbrains.job.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public List<CategoryHomeFeaturedDto> getHomeFeaturedCategories() {

        List<Category> categories = categoryRepository.findAll();
        List<CategoryHomeFeaturedDto> categoryHomeFeaturedDtoList = categories.stream()
                .map(category -> new CategoryHomeFeaturedDto(category.getId(), category.getName(), category.getIcon(), category.getVacancies().size())).toList();
        return categoryHomeFeaturedDtoList;
    }
}
