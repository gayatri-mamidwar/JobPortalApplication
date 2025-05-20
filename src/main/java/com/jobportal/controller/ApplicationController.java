package com.jobportal.controller;


import com.jobportal.dto.ApplicationDTO;
import com.jobportal.service.ApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/api/applications")
    public class ApplicationController {

        private ApplicationService applicationService;

        public ApplicationController(ApplicationService applicationService){
            this.applicationService = applicationService;
        }

        @PostMapping
        public ResponseEntity<ApplicationDTO> createApplication(@RequestBody ApplicationDTO dto) {
            return new ResponseEntity<>(applicationService.createApplication(dto), HttpStatus.CREATED);
        }

        @GetMapping
        public List<ApplicationDTO> getAllApplications() {
            return applicationService.getAllApplications();
        }

        @GetMapping("/user/{userId}")
        public List<ApplicationDTO> getApplicationsByUser(@PathVariable Long userId) {
            return applicationService.getApplicationsByUserId(userId);
        }

        @GetMapping("/job/{jobId}")
        public List<ApplicationDTO> getApplicationByJob(@PathVariable Long jobId) {
            return applicationService.getApplicationsByJobId(jobId);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
            applicationService.deleteApplication(id);
            return ResponseEntity.noContent().build();
        }

}
