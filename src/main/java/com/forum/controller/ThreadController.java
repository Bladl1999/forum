package com.forum.controller;

import com.forum.model.dto.ThreadDTO;
import com.forum.service.ThreadService;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("/threads")
public class ThreadController {
    private final ThreadService threadService;

    @GetMapping("{/id}")
    public ResponseEntity<ThreadDTO> getById(@PathVariable UUID id){
        return ResponseEntity.ok(threadService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ThreadDTO>> getAll(){
        return ResponseEntity.ok(threadService.findAll());
    }

    @PostMapping
    public ResponseEntity<ThreadDTO> saveThread(@RequestBody ThreadDTO threadDTO){
        return ResponseEntity.ok(threadService.update(threadDTO));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ThreadDTO> updateThread(@RequestBody ThreadDTO threadDTO){
        return ResponseEntity.ok(threadService.update(threadDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ThreadDTO> deleteThread(@PathVariable UUID id){
        return ResponseEntity.ok(threadService.deleteById(id));
    }

}
