package com.forum.controller;

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
    public ResponseEntity<Users> getById(@PathVariable Long id) {
        return ResponseEntity.ok(usersService.findById(id));
    }


    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        return ResponseEntity.ok(usersService.findAll());
    }

    @PostMapping
    public ResponseEntity<Users> saveUsers(@RequestBody Users users) {
        return new ResponseEntity<>(usersService.saveUser(users), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@RequestBody Users users) {
        return ResponseEntity.ok(usersService.updateById(users));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Users> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(usersService.deleteById(id));
    }
}
