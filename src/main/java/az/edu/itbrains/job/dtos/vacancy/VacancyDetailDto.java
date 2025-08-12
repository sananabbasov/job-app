package az.edu.itbrains.job.dtos.vacancy;

import az.edu.itbrains.job.dtos.category.CategoryDto;
import az.edu.itbrains.job.dtos.category.CategoryHomeFeaturedDto;
import az.edu.itbrains.job.dtos.company.CompanyDto;
import az.edu.itbrains.job.dtos.jobType.JobTypeDto;
import az.edu.itbrains.job.dtos.location.LocationDto;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VacancyDetailDto {
    private Long id;
    private String title;
    private LocationDto location;
    private JobTypeDto jobType;
    private String description;
    private String responsibility;
    private String qualification;
    private int minSalary;
    private int maxSalary;
    private Date dateLine;
    private CompanyDto company;
    private CategoryDto category;
}
