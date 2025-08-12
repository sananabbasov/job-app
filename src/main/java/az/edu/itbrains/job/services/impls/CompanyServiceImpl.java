package az.edu.itbrains.job.services.impls;

import az.edu.itbrains.job.dtos.company.CompanyCreateDto;
import az.edu.itbrains.job.models.Company;
import az.edu.itbrains.job.repositories.CompanyRepository;
import az.edu.itbrains.job.services.CompanyService;
import az.edu.itbrains.job.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    @Override
    public boolean createCompany(CompanyCreateDto companyCreateDto, String email) {
        try {
            Company company = new Company();
            company.setName(companyCreateDto.getName());
            company.setPhotoUrl(companyCreateDto.getPhotoUrl());
            company.setDescription(companyCreateDto.getDescription());
            companyRepository.save(company);
            boolean result = userService.assingCompanyToUser(company, email);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
