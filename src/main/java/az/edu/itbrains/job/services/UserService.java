package az.edu.itbrains.job.services;

import az.edu.itbrains.job.dtos.auth.RegisterDto;
import az.edu.itbrains.job.models.Company;
import az.edu.itbrains.job.models.User;

public interface UserService {
    boolean registerUser(RegisterDto registerDto);

    User findUserByEmail(String email);

    boolean findCompanyByEmail(String name);

    boolean assingCompanyToUser(Company company, String email);
}
