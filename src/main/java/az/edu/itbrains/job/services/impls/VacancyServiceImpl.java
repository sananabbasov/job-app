package az.edu.itbrains.job.services.impls;

import az.edu.itbrains.job.dtos.vacancy.*;
import az.edu.itbrains.job.models.*;
import az.edu.itbrains.job.repositories.VacancyRepository;
import az.edu.itbrains.job.services.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VacancyServiceImpl implements VacancyService {

    private final VacancyRepository vacancyRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CompanyService companyService;
    private final CategoryService categoryService;
    private final LocationService locationService;
    private final JobTypeService jobTypeService;

    @Override
    public List<VacancyHomeListDto> getAllVacancy() {
        List<Vacancy> vacancies = vacancyRepository.findAll(); // SELECT * FROM vacancies LIMIT 8
        List<VacancyHomeListDto> vacancyHomeListDtoList = vacancies.stream().map(vacancy -> modelMapper.map(vacancy, VacancyHomeListDto.class)).toList();
        return vacancyHomeListDtoList;
    }

    @Override
    public List<VacancyListDto> getVacancyList() {
        List<Vacancy> vacancies = vacancyRepository.findAll(); // SELECT * FROM vacancies LIMIT 8
        List<VacancyListDto> vacancyListDtoList = vacancies.stream().map(vacancy -> modelMapper.map(vacancy, VacancyListDto.class)).toList();
        return vacancyListDtoList;
    }

    @Override
    public VacancyDetailDto getVacancyById(Long id) {
        Vacancy vacancy = vacancyRepository.findById(id).orElseThrow();
        VacancyDetailDto vacancyDetailDto = modelMapper.map(vacancy, VacancyDetailDto.class);
        return vacancyDetailDto;
    }

    @Override
    public boolean createVacancies(VacancyCreateDto vacancyCreateDto, String email) {
        try {
            User user = userService.findUserByEmail(email);
            if (user.getCompany()==null){
                return false;
            }
            Vacancy vacancy = new Vacancy();
            vacancy.setTitle(vacancyCreateDto.getTitle());
            vacancy.setDescription(vacancyCreateDto.getDescription());
            vacancy.setResponsibility(vacancyCreateDto.getResponsibility());
            vacancy.setQualification(vacancyCreateDto.getQualification());
            vacancy.setMinSalary(vacancyCreateDto.getMinSalary());
            vacancy.setMaxSalary(vacancyCreateDto.getMaxSalary());
            vacancy.setDateLine(vacancyCreateDto.getDateLine());
            Category category = categoryService.findCategoryById(vacancyCreateDto.getCategoryId());
            vacancy.setCategory(category);
            Location location = locationService.findLocationById(vacancyCreateDto.getLocationId());
            vacancy.setLocation(location);
            JobType jobType = jobTypeService.findJobTypeById(vacancyCreateDto.getJobTypeId());;
            vacancy.setJobType(jobType);
            vacancy.setCompany(user.getCompany());
            vacancyRepository.save(vacancy);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public List<VacancyDashboardDto> getUserVacancies(String name) {
        User user = userService.findUserByEmail(name);
        Long companyId = user.getCompany().getId();
        List<Vacancy> vacancies = vacancyRepository.findByCompanyId(companyId);
        List<VacancyDashboardDto> vacancyDashboardDtoList = vacancies.stream()
                .map(vacancy -> modelMapper.map(vacancy, VacancyDashboardDto.class))
                .toList();
        return vacancyDashboardDtoList;
    }
}
