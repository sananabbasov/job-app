package az.edu.itbrains.job.controllers;


import az.edu.itbrains.job.dtos.category.CategoryHomeFeaturedDto;
import az.edu.itbrains.job.dtos.jobType.JobTypeDto;
import az.edu.itbrains.job.dtos.vacancy.VacancyHomeListDto;
import az.edu.itbrains.job.services.CategoryService;
import az.edu.itbrains.job.services.JobTypeService;
import az.edu.itbrains.job.services.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final CategoryService categoryService;
    private final VacancyService vacancyService;
    private final JobTypeService jobTypeService;



    @GetMapping("/")
    public String index(Model model){
        List<CategoryHomeFeaturedDto> categoryHomeFeaturedDtoList = categoryService.getHomeFeaturedCategories();
        List<VacancyHomeListDto> vacancyHomeListDtoList = vacancyService.getAllVacancy();
        List<JobTypeDto> jobTypeDtoList = jobTypeService.getHomeJobTypes();
        model.addAttribute("categories",categoryHomeFeaturedDtoList);
        model.addAttribute("jobTypes", jobTypeDtoList);
        model.addAttribute("vacancyHomeListDtoList",vacancyHomeListDtoList);
        return "index.html";
    }


    @GetMapping("/contact")
    public String contact(){
        return "contact.html";
    }


    @GetMapping("/about")
    public String about(){
        return "about.html";
    }
}
