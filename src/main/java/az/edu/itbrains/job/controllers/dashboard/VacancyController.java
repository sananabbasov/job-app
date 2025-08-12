package az.edu.itbrains.job.controllers.dashboard;


import az.edu.itbrains.job.dtos.vacancy.VacancyDashboardDto;
import az.edu.itbrains.job.services.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class VacancyController {


    private final VacancyService vacancyService;

    @GetMapping("/dashboard/vacancy")
    @PreAuthorize("isAuthenticated()")
    public String index(Principal principal, Model model){
        List<VacancyDashboardDto> vacancyDashboardDtoList = vacancyService.getUserVacancies(principal.getName());
        model.addAttribute("vacancies", vacancyDashboardDtoList);
        return "dashboard/vacancies/index.html";
    }


}
