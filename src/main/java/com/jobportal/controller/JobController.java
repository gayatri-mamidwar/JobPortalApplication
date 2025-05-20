package com.jobportal.controller;

import com.jobportal.dto.EmployerDTO;
import com.jobportal.dto.JobDTO;
import com.jobportal.service.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {


    private JobService jobService;

    public JobController(JobService jobService){
        this.jobService = jobService;
    }

    @PostMapping
    public ResponseEntity<JobDTO> createJob(@RequestBody JobDTO jobDTO) {
        return ResponseEntity.ok(jobService.createJob(jobDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobDTO> getJob(@PathVariable Long id) {
        return ResponseEntity.ok(jobService.getJobById(id));
    }

    @GetMapping
    public ResponseEntity<List<JobDTO>> getAllJobs() {
        return ResponseEntity.ok(jobService.getAllJobs());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<JobDTO> deleteEmployer(@PathVariable Long id){
        return ResponseEntity.ok(jobService.deleteById(id));
    }
}

