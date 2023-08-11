package com.forum.service.impl;

import com.forum.exceptions.NoSuchEntity;
import com.forum.model.dto.UsersDTO;
import com.forum.model.mapper.UsersMapper;
import com.forum.repository.UsersRepository;
import com.forum.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final UsersMapper usersMapper;

    public UsersDTO findById(UUID id) {
        return usersRepository.findById(id).map(usersMapper::toDto).orElseThrow(() -> new NoSuchEntity("No such value!"));
    }

    public List<UsersDTO> findAll() {
        return usersRepository.findAll().stream().map(usersMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UsersDTO saveUser(UsersDTO usersDTO) {
        return usersMapper.toDto(usersRepository.saveAndFlush(usersMapper.toEntity(usersDTO)));
    }

    @Transactional
    public UsersDTO deleteById(UUID id) {
        UsersDTO usersFromDB = findById(id);
        usersRepository.deleteById(id);
        return usersFromDB;
    }

    @Override
    @Transactional
    public UsersDTO update(UsersDTO usersDTO) {
        return usersRepository.findById(usersDTO.getId()).map(user -> {
            usersMapper.update(usersDTO, user);
            return user;
        }).map(usersMapper::toDto).orElseThrow(() -> new NoSuchEntity("No such value!"));
    }

}
