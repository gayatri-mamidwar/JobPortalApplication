package com.jobportal.serviceImpl;

import com.jobportal.dto.EmployerDTO;
import com.jobportal.dto.UserDTO;
import com.jobportal.entity.User;
import com.jobportal.exception.UserNotFoundException;
import com.jobportal.repository.UserRepository;
import com.jobportal.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = mapToEntity(userDTO);

//        return userRepository.save(mapToDTO(user));         //Wrong. 1st save to repo then convert to DTO
        return mapToDTO(userRepository.save(user));
    }

    //here, this:: means current class
    @Override
    public UserDTO getUserById(Long id) {
        return  userRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new RuntimeException("User not found.."));

    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public UserDTO deleteById(Long id) {
        return userRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new RuntimeException("User not found.."));
    }
}
