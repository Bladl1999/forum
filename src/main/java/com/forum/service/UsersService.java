package com.forum.service;

import com.forum.model.dto.UsersDTO;

import java.util.List;
import java.util.UUID;

public interface UsersService {

    UsersDTO findById(UUID id);

    List<UsersDTO> findAll();

    UsersDTO saveUser(UsersDTO usersDTO);

    UsersDTO deleteById(UUID id);

    UsersDTO update(UsersDTO usersDTO);


}
