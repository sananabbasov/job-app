package az.edu.itbrains.job.controllers.dashboard;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class DashboardController {


    @GetMapping("/dashboard")
    public String index(){
        return "dashboard/index.html";
    }
}
