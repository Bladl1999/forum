package com.forum.service;

import com.forum.model.entity.Users;

import java.util.List;

public interface UsersService {

    Users findById(long id);

    List<Users> findAll();

    Users saveUser(Users users);

    Users deleteById(Long id);

    Users updateById(Users users);


}
