package az.edu.itbrains.job.services.impls;

import az.edu.itbrains.job.dtos.jobType.JobTypeDto;
import az.edu.itbrains.job.models.JobType;
import az.edu.itbrains.job.repositories.JobTypeRepository;
import az.edu.itbrains.job.services.JobTypeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobTypeServiceImpl implements JobTypeService {

    private final JobTypeRepository jobTypeRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<JobTypeDto> getHomeJobTypes() {
        List<JobType> jobTypeList = jobTypeRepository.findAll();
        List<JobTypeDto> jobTypeDtoList = jobTypeList.stream().map(jobType -> modelMapper.map(jobType, JobTypeDto.class)).toList();
        return jobTypeDtoList;
    }

    @Override
    public List<JobTypeDto> getVacanciesJobTypes() {
        List<JobType> jobTypeList = jobTypeRepository.findAll();
        List<JobTypeDto> jobTypeDtoList = jobTypeList.stream().map(jobType -> modelMapper.map(jobType, JobTypeDto.class)).toList();
        return jobTypeDtoList;
    }

    @Override
    public JobType findJobTypeById(Long jobTypeId) {
        return jobTypeRepository.findById(jobTypeId).orElseThrow();
    }
}
