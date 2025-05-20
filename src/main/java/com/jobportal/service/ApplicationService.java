package com.jobportal.service;

import com.jobportal.dto.ApplicationDTO;

import java.util.List;

public interface ApplicationService {
    ApplicationDTO createApplication(ApplicationDTO dto);
    List<ApplicationDTO> getAllApplications();
    List<ApplicationDTO> getApplicationsByUserId(Long userId);
    List<ApplicationDTO> getApplicationsByJobId(Long jobId);
    void deleteApplication(Long id);
}
