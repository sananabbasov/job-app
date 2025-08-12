package az.edu.itbrains.job.dtos.vacancy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VacancyCreateDto {
    private String title;
    private String description;
    private String responsibility;
    private String qualification;
    private int minSalary;
    private int maxSalary;
    private LocalDate dateLine;
    private Long categoryId;
    private Long locationId;
    private Long jobTypeId;
}
