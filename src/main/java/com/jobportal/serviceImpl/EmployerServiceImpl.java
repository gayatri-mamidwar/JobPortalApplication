package com.jobportal.serviceImpl;

import com.jobportal.dto.EmployerDTO;
import com.jobportal.entity.Employer;
import com.jobportal.entity.User;
import com.jobportal.exception.EmployerNotFoundException;
import com.jobportal.exception.UserNotFoundException;
import com.jobportal.repository.EmployerRepository;
import com.jobportal.service.EmployerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerServiceImpl implements EmployerService {

    private EmployerRepository employerRepository;

    public EmployerServiceImpl(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    private EmployerDTO mapToDTO(Employer employer) {
        //here we are getting already present Id in db from Employer obj.
        return new EmployerDTO(employer.getId(), employer.getCompanyName(), employer.getEmail());
    }

    private Employer mapToEntity(EmployerDTO dto) {
        Employer employer = new Employer();

        //DTO wont have id so no need to set. JPA automatically handles ID creation for new record
        employer.setCompanyName(dto.getCompanyName());
        employer.setEmail(dto.getEmail());
        return employer;
    }

    @Override
    public EmployerDTO createEmployer(EmployerDTO employerDTO) {
        Employer employer = mapToEntity(employerDTO);

        return mapToDTO(employerRepository.save(employer));
    }

    @Override
    public EmployerDTO getEmployerById(Long id) {
        return employerRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new EmployerNotFoundException(id));
    }

    @Override
    public List<EmployerDTO> getAllEmployers() {
        return employerRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public EmployerDTO deleteById(Long id) {
        Employer employer = employerRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        employerRepository.deleteById(id);
        return mapToDTO(employer);
    }
}
