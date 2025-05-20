package com.jobportal.service;

import com.jobportal.dto.EmployerDTO;

import java.util.List;

public interface EmployerService {
    EmployerDTO createEmployer(EmployerDTO employerDTO);

    EmployerDTO getEmployerById(Long id);

    List<EmployerDTO> getAllEmployers();

    EmployerDTO deleteById(Long id);
}
