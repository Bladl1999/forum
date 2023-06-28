package com.forum.controller;

import com.forum.model.dto.UsersDTO;
import com.forum.model.entity.Users;
import com.forum.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;

    @GetMapping("/{id}")
    public ResponseEntity<UsersDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(usersService.findById(id));
    }


    @GetMapping
    public ResponseEntity<List<UsersDTO>> getAllUsers() {
        return ResponseEntity.ok(usersService.findAll());
    }

    @PostMapping
    public ResponseEntity<UsersDTO> saveUsers(@RequestBody UsersDTO usersDTO) {
        return new ResponseEntity<>(usersService.saveUser(usersDTO), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UsersDTO> updateUser(@PathVariable long id, @RequestBody UsersDTO usersDTO) {
        return ResponseEntity.ok(usersService.update(usersDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsersDTO> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(usersService.deleteById(id));
    }
}
