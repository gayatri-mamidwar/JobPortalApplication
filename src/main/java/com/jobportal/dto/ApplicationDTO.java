package com.jobportal.dto;

import java.time.LocalDate;

//Here, DTO is acting as request and response hence used id attribute also
public class ApplicationDTO {
    private Long id;
    private LocalDate appliedDate;
    private Long userId;
    private Long jobId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(LocalDate appliedDate) {
        this.appliedDate = appliedDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }
}
