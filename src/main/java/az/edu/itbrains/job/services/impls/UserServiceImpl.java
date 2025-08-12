package az.edu.itbrains.job.services.impls;

import az.edu.itbrains.job.dtos.auth.RegisterDto;
import az.edu.itbrains.job.models.Company;
import az.edu.itbrains.job.models.User;
import az.edu.itbrains.job.repositories.UserRepository;
import az.edu.itbrains.job.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean registerUser(RegisterDto registerDto) {
        try {
            User findUser = userRepository.findByEmail(registerDto.getEmail());
            if (findUser != null){
                return false;
            }

            User user = new User();
            user.setName(registerDto.getName());
            user.setSurname(registerDto.getSurname());
            user.setEmail(registerDto.getEmail());
            String password = passwordEncoder.encode(registerDto.getPassword());
            user.setPassword(password);

            if (registerDto.getCompanyName() != null){
                Company company = new Company();
                company.setName(registerDto.getCompanyName());
                user.setCompany(company);
            }

            userRepository.save(user);

            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean findCompanyByEmail(String name) {
        boolean user = userRepository.findByEmail(name).getCompany() == null;
        return user;
    }

    @Override
    public boolean assingCompanyToUser(Company company, String email) {
        try {
            User findUser = userRepository.findByEmail(email);
            findUser.setCompany(company);
            userRepository.save(findUser);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
