package com.jobportal.serviceImpl;

import com.jobportal.dto.ApplicationDTO;
import com.jobportal.entity.Application;
import com.jobportal.entity.Job;
import com.jobportal.entity.User;
import com.jobportal.exception.JobNotFoundException;
import com.jobportal.exception.UserNotFoundException;
import com.jobportal.repository.ApplicationRepository;
import com.jobportal.repository.JobRepository;
import com.jobportal.repository.UserRepository;
import com.jobportal.service.ApplicationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private ApplicationRepository applicationRepository;
    private UserRepository userRepository;
    private JobRepository jobRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository,
                                  UserRepository userRepository,
                                  JobRepository jobRepository) {
        this.applicationRepository = applicationRepository;
        this.userRepository = userRepository;
        this.jobRepository = jobRepository;
    }

    @Override
    public ApplicationDTO createApplication(ApplicationDTO dto) {
        Application newApplication = mapToEntity(dto);
        applicationRepository.save(newApplication);

        return mapToDTO(newApplication);
    }

    @Override
    public List<ApplicationDTO> getAllApplications() {
        return applicationRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ApplicationDTO> getApplicationsByUserId(Long userId) {
        List<Application> applications = applicationRepository.findByUserId(userId);

        return applications.stream()
                        .map(this::mapToDTO)
                .collect(Collectors.toList());

    }

    @Override
    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }

    @Override
    public List<ApplicationDTO> getApplicationsByJobId(Long jobId) {
        return applicationRepository.findByJobId(jobId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private ApplicationDTO mapToDTO(Application app) {
        ApplicationDTO dto = new ApplicationDTO();
        dto.setId(app.getId());
        dto.setAppliedDate(app.getAppliedDate());
        dto.setUserId(app.getUser().getId());
        dto.setJobId(app.getJob().getId());
        return dto;
    }

    private Application mapToEntity(ApplicationDTO appDto){
        Application app = new Application();
        app.setAppliedDate(appDto.getAppliedDate());

        //fetch User and Job entity
        User user = userRepository.findById(appDto.getUserId())
                .orElseThrow(() -> new UserNotFoundException(appDto.getUserId()));

        Job job = jobRepository.findById(appDto.getJobId())
                .orElseThrow(() -> new JobNotFoundException(appDto.getJobId()));

        //set Job and User fields of Application
        app.setJob(job);
        app.setUser(user);

        return app;
    }
}
