package az.edu.itbrains.job.services;

import az.edu.itbrains.job.dtos.vacancy.VacancyHomeListDto;

import java.util.List;

public interface VacancyService {
    List<VacancyHomeListDto> getAllVacancy();
}
