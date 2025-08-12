package az.edu.itbrains.job.services.impls;

import az.edu.itbrains.job.dtos.location.LocationDto;
import az.edu.itbrains.job.models.Location;
import az.edu.itbrains.job.repositories.LocationRepository;
import az.edu.itbrains.job.services.LocationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<LocationDto> getVacanciesLocations() {
        List<Location> locations = locationRepository.findAll();
        List<LocationDto> locationDtoList = locations.stream().map(location -> modelMapper.map(location, LocationDto.class)).collect(Collectors.toList());
        return locationDtoList;
    }

    @Override
    public Location findLocationById(Long locationId) {
        return locationRepository.findById(locationId).orElseThrow();
    }
}
