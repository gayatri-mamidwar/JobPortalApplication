package com.jobportal.controller;

import com.jobportal.dto.EmployerDTO;
import com.jobportal.service.EmployerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {

    private EmployerService employerService;

    public EmployerController(EmployerService employerService){
        this.employerService = employerService;
    }

    @PostMapping
    public ResponseEntity<EmployerDTO> createEmployer(@RequestBody EmployerDTO employerDTO) {
        return ResponseEntity.ok(employerService.createEmployer(employerDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployerDTO> getEmployer(@PathVariable Long id) {
        return ResponseEntity.ok(employerService.getEmployerById(id));
    }

    @GetMapping
    public ResponseEntity<List<EmployerDTO>> getAllEmployers() {
        return ResponseEntity.ok(employerService.getAllEmployers());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmployerDTO> deleteEmployer(@PathVariable Long id){
        return ResponseEntity.ok(employerService.deleteById(id));
    }
}

