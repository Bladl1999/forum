package com.forum.controller;

import com.forum.model.entity.Users;
import com.forum.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor //делает Autowired
@RequestMapping("users")
public class UsersController {
    private final UsersService usersService;

//    @Autowired
//    public UsersController(UsersService usersService) {
//        this.usersService = usersService;
//    }
    @GetMapping("/{id}")
    public ResponseEntity<Users> getById(@PathVariable Long id){
        return ResponseEntity.ok(usersService.findById(id));
    }


    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        return ResponseEntity.ok(usersService.findAll()); // Какой статус надо возвращать при возвращении объекта
    }

    @PostMapping
    public ResponseEntity<Users> saveUsers(@RequestBody Users users) {
       return new ResponseEntity<>(usersService.saveUser(users), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@RequestBody Users users) {
        //return ResponseEntity.accepted(usersService.updateById(users));
        //return new ResponseEntity<>(usersService.updateById(users), HttpStatus.ACCEPTED);
        return ResponseEntity.ok(usersService.updateById(users));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Users> deleteUser(Long id) {
       // return new ResponseEntity<>(usersService.deleteById(id), HttpStatus.NO_CONTENT);
        return ResponseEntity.ok(usersService.deleteById(id));
    }
}
