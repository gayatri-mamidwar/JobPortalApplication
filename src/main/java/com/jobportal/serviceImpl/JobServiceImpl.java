package com.jobportal.serviceImpl;

import com.jobportal.dto.JobDTO;
import com.jobportal.entity.Employer;
import com.jobportal.entity.Job;
import com.jobportal.entity.User;
import com.jobportal.exception.EmployerNotFoundException;
import com.jobportal.exception.JobNotFoundException;
import com.jobportal.exception.UserNotFoundException;
import com.jobportal.repository.EmployerRepository;
import com.jobportal.repository.JobRepository;
import com.jobportal.service.JobService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;
    private EmployerRepository employerRepository;

    public JobServiceImpl(JobRepository jobRepository, EmployerRepository employerRepository) {
        this.jobRepository = jobRepository;
        this.employerRepository = employerRepository;
    }

    private JobDTO mapToDTO(Job job) {
        return new JobDTO(
                job.getId(),
                job.getTitle(),
                job.getDescription(),
                job.getLocation(),
                job.getType(),
                job.getEmployer().getId()
        );
    }

    private Job mapToEntity(JobDTO dto) {
        Job job = new Job();
        job.setTitle(dto.getTitle());
        job.setDescription(dto.getDescription());
        job.setLocation(dto.getLocation());
        job.setType(dto.getType());

        Employer employer = employerRepository.findById(dto.getEmployerId())
                .orElseThrow(() -> new EmployerNotFoundException(dto.getEmployerId()));

        job.setEmployer(employer);
        return job;
    }

    @Override
    public JobDTO createJob(JobDTO jobDTO) {
        Job job = mapToEntity(jobDTO);
        return mapToDTO(jobRepository.save(job));
    }

    @Override
    public JobDTO getJobById(Long id) {
        return jobRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new JobNotFoundException(id));
    }

    @Override
    public List<JobDTO> getAllJobs() {
        return jobRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public JobDTO deleteById(Long id) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        jobRepository.deleteById(id);
        return mapToDTO(job);
    }
}
