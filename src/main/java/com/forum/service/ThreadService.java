package com.forum.service;

import com.forum.model.dto.ThreadDTO;

import java.util.List;
import java.util.UUID;

public interface ThreadService {

    ThreadDTO findById(UUID id);

    List<ThreadDTO> findAll();

    ThreadDTO saveThread(ThreadDTO threadDTO);

    ThreadDTO deleteById(UUID id);

    ThreadDTO update(ThreadDTO threadDTO);

}
