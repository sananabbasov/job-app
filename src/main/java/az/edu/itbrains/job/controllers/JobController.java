package az.edu.itbrains.job.controllers;


import az.edu.itbrains.job.dtos.category.CategoryDto;
import az.edu.itbrains.job.dtos.jobType.JobTypeDto;
import az.edu.itbrains.job.dtos.location.LocationDto;
import az.edu.itbrains.job.dtos.vacancy.VacancyCreateDto;
import az.edu.itbrains.job.dtos.vacancy.VacancyDetailDto;
import az.edu.itbrains.job.dtos.vacancy.VacancyListDto;
import az.edu.itbrains.job.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class JobController {

    private final VacancyService vacancyService;
    private final JobTypeService jobTypeService;
    private final LocationService locationService;
    private final CategoryService categoryService;
    private final UserService userService;


    @GetMapping("/jobs") // localhost:8080/jobs
    public String job(Model model){
        List<VacancyListDto>  vacancyListDtoList = vacancyService.getVacancyList();
        model.addAttribute("jobs", vacancyListDtoList);
        return "job/job.html";
    }

    @GetMapping("/detail/{id}") // localhost:8080/detail/23
    public String detail(@PathVariable Long id, Model model){
        VacancyDetailDto vacancyDetailDto = vacancyService.getVacancyById(id);
        boolean checkDate = vacancyDetailDto.getDateLine().before(new Date());
        model.addAttribute("job", vacancyDetailDto);
        model.addAttribute("jobDate", checkDate);
        return "job/detail.html";
    }

    @GetMapping("/post/job")
    @PreAuthorize("isAuthenticated()")
    public String createJob(Model model, Principal principal){

        boolean findCompany = userService.findCompanyByEmail(principal.getName());
        if (findCompany){
            return "redirect:/company/create";
        }

        List<CategoryDto> categoryDtoList = categoryService.getVacanciesCategories();
        List<JobTypeDto> jobTypeDtoList = jobTypeService.getVacanciesJobTypes();
        List<LocationDto> locationDtoList = locationService.getVacanciesLocations();

        model.addAttribute("categories", categoryDtoList);
        model.addAttribute("jobTypes", jobTypeDtoList);
        model.addAttribute("locations", locationDtoList);
        return "job/create.html";
    }


    @PostMapping("/post/job")
    @PreAuthorize("isAuthenticated()")
    public String createJob(Model model, VacancyCreateDto vacancyCreateDto, Principal principal){

        String email = principal.getName();
        boolean result = vacancyService.createVacancies(vacancyCreateDto, email);

        return "redirect:/jobs";
    }

}
