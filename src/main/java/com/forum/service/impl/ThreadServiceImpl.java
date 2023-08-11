package com.forum.service.impl;

import com.forum.exceptions.NoSuchEntity;
import com.forum.model.dto.ThreadDTO;
import com.forum.model.mapper.ThreadMapper;
import com.forum.repository.ThreadRepository;
import com.forum.service.ThreadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ThreadServiceImpl implements ThreadService{

    private final ThreadRepository threadRepository;
    private final ThreadMapper threadMapper;


    public ThreadDTO findById(UUID id) {
        return threadRepository.findById(id).map(threadMapper::toDto).orElseThrow(() -> new NoSuchEntity("No such value!"));
    }

    public List<ThreadDTO> findAll() {
        return threadRepository.findAll().stream().map(threadMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ThreadDTO saveThread(ThreadDTO threadDTO) {
        return threadMapper.toDto(threadRepository.saveAndFlush(threadMapper.toEntity(threadDTO)));
    }

    @Transactional
    public ThreadDTO deleteById(UUID id) {
        ThreadDTO threadFromDB = findById(id);
        threadRepository.deleteById(id);
        return threadFromDB;
    }

    @Override
    @Transactional
    public ThreadDTO update(ThreadDTO threadDTO) {
        return threadRepository.findById(threadDTO.getId()).map(thread -> {
            threadMapper.update(threadDTO, thread);
            return thread;
        }).map(threadMapper::toDto).orElseThrow(() -> new NoSuchEntity("No such value!"));
    }
}
