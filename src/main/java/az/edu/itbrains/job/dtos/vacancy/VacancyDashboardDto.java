package az.edu.itbrains.job.dtos.vacancy;

import az.edu.itbrains.job.dtos.company.CompanyDto;
import az.edu.itbrains.job.dtos.jobType.JobTypeDto;
import az.edu.itbrains.job.dtos.location.LocationDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VacancyDashboardDto {
    private Long id;
    private String title;
    private LocationDto location;
    private JobTypeDto jobType;
    private int minSalary;
    private int maxSalary;
    private Date dateLine;
    private CompanyDto company;
}
