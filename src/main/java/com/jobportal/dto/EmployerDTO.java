package com.jobportal.dto;


//Here, DTO is acting as request and response hence used id attribute also
public class EmployerDTO {
    private Long id;
    private String companyName;
    private String email;

    public EmployerDTO(Long id, String companyName, String email) {
        this.id = id;
        this.companyName = companyName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
