package com.jobportal.controller;

import com.jobportal.dto.EmployerDTO;
import com.jobportal.dto.UserDTO;
import com.jobportal.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.createUser(userDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    /* If you are not using a global exception handler (@RestControllerAdvice),
    then you need to manually handle exceptions inside each controller method using try-catch blocks. like below-

      @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        try {
            User user = userService.getUserById(id);
            UserResponseDTO dto = convertToDto(user);
            return ResponseEntity.ok(dto);
        } catch (UserNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("User not found with id: " + id);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Something went wrong: " + ex.getMessage());
        }
    }
     */

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> deleteEmployer(@PathVariable Long id){
        return ResponseEntity.ok(userService.deleteById(id));
    }
}

