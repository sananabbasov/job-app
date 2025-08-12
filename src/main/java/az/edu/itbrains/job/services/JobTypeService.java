package az.edu.itbrains.job.services;

import az.edu.itbrains.job.dtos.jobType.JobTypeDto;
import az.edu.itbrains.job.models.JobType;

import java.util.List;

public interface JobTypeService {
    List<JobTypeDto> getHomeJobTypes();

    List<JobTypeDto> getVacanciesJobTypes();

    JobType findJobTypeById(Long jobTypeId);
}
