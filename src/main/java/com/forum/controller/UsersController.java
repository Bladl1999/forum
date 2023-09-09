package com.forum.controller;

import com.forum.model.dto.UsersDTO;
import com.forum.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;

    @GetMapping("/{id}")
    public ResponseEntity<UsersDTO> getById(@PathVariable UUID id) {
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
    public ResponseEntity<UsersDTO> updateUser(@RequestBody UsersDTO usersDTO) {
        return ResponseEntity.ok(usersService.update(usersDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsersDTO> deleteUser(@PathVariable UUID id) {
        return ResponseEntity.ok(usersService.deleteById(id));
    }
}
