package az.edu.itbrains.job.repositories;

import az.edu.itbrains.job.models.JobType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTypeRepository extends JpaRepository<JobType, Long> {
}
