package com.jobportal.repository;

import com.jobportal.dto.ApplicationDTO;
import com.jobportal.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    //Jpa methods always work with Entity not Dto
    List<Application> findByUserId(Long userId);
    List<Application> findByJobId(Long jobId);
}
