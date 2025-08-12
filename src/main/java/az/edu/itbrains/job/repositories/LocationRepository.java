package az.edu.itbrains.job.repositories;

import az.edu.itbrains.job.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
