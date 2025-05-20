package com.jobportal.service;

import com.jobportal.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    UserDTO getUserById(Long id);

    List<UserDTO> getAllUsers();

    UserDTO deleteById(Long id);
}
