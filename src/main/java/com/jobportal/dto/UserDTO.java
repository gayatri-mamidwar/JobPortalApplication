package com.jobportal.dto;

import com.jobportal.entity.User;


//Here, DTO is acting as request and response hence used id attribute also
public class UserDTO {
    private Long id;
    private String name;
    private String email;

    public UserDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }


    //if Using setter no need to add param constructor. and if using param constructor no needd to add setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    private UserDTO mapToDTO(User user) {
        return new UserDTO(user.getId(), user.getName(), user.getEmail());
    }

    private User mapToEntity(UserDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return user;
    }
}
