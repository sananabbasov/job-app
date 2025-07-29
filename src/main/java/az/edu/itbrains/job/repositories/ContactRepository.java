package az.edu.itbrains.job.repositories;

import az.edu.itbrains.job.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
