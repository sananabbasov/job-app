package az.edu.itbrains.job.dtos.jobType;

import az.edu.itbrains.job.dtos.vacancy.VacancyHomeListDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobTypeDto {
    private Long id;
    private String name;
    private List<VacancyHomeListDto> vacancies;
}
