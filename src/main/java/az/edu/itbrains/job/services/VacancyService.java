package az.edu.itbrains.job.services;

import az.edu.itbrains.job.dtos.vacancy.*;

import java.util.List;

public interface VacancyService {
    List<VacancyHomeListDto> getAllVacancy();

    List<VacancyListDto> getVacancyList();

    VacancyDetailDto getVacancyById(Long id);

    boolean createVacancies(VacancyCreateDto vacancyCreateDto, String email);

    List<VacancyDashboardDto> getUserVacancies(String name);
}
