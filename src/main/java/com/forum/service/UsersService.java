package com.forum.service;

import com.forum.model.dto.UsersDTO;

import java.util.List;

public interface UsersService {

    UsersDTO findById(long id);

    List<UsersDTO> findAll();

    UsersDTO saveUser(UsersDTO usersDTO);

    UsersDTO deleteById(long id);

    UsersDTO update(UsersDTO usersDTO, long id);


}
