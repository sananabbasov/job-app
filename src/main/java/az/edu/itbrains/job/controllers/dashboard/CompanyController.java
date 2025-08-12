package az.edu.itbrains.job.controllers.dashboard;


import az.edu.itbrains.job.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/dashboard/company")
    public String index(){
        return "dashboard/company/index.html";
    }
}
