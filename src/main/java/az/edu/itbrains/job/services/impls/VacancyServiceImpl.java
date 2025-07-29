package az.edu.itbrains.job.services.impls;

import az.edu.itbrains.job.dtos.vacancy.VacancyHomeListDto;
import az.edu.itbrains.job.models.Vacancy;
import az.edu.itbrains.job.repositories.VacancyRepository;
import az.edu.itbrains.job.services.VacancyService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VacancyServiceImpl implements VacancyService {

    private final VacancyRepository vacancyRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<VacancyHomeListDto> getAllVacancy() {
        List<Vacancy> vacancies = vacancyRepository.findAll();
        List<VacancyHomeListDto> vacancyHomeListDtoList = vacancies.stream().map(vacancy -> modelMapper.map(vacancy, VacancyHomeListDto.class)).toList();
        return vacancyHomeListDtoList;
    }
}
