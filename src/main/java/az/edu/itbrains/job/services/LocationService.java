package az.edu.itbrains.job.services;

import az.edu.itbrains.job.dtos.location.LocationDto;
import az.edu.itbrains.job.models.Location;

import java.util.List;

public interface LocationService {
    List<LocationDto> getVacanciesLocations();

    Location findLocationById(Long locationId);
}
