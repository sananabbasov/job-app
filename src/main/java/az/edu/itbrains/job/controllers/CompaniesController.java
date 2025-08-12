package az.edu.itbrains.job.controllers;


import az.edu.itbrains.job.dtos.company.CompanyCreateDto;
import az.edu.itbrains.job.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class CompaniesController {

    private final CompanyService companyService;


    @GetMapping("/company/create")
    @PreAuthorize("isAuthenticated()")
    public String index(){
        return "job/company-create.html";
    }


    @PostMapping("/company/create")
    @PreAuthorize("isAuthenticated()")
    public String create(CompanyCreateDto companyCreateDto, Principal principal){
        String email = principal.getName();
        boolean result = companyService.createCompany(companyCreateDto, email);
        return "redirect:/post/job";
    }
}
