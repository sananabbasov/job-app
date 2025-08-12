package az.edu.itbrains.job.services;

import az.edu.itbrains.job.dtos.company.CompanyCreateDto;

public interface CompanyService {
    boolean createCompany(CompanyCreateDto companyCreateDto, String email);
}
