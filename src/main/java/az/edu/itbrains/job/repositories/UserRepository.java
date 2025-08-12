package az.edu.itbrains.job.repositories;

import az.edu.itbrains.job.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
