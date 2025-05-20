package com.jobportal.service;

import com.jobportal.dto.JobDTO;

import java.util.List;

public interface JobService {
    JobDTO createJob(JobDTO jobDTO);

    JobDTO getJobById(Long id);

    List<JobDTO> getAllJobs();

    JobDTO deleteById(Long id);
}
