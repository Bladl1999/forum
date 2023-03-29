package com.forum.service.impl;

import com.forum.exceptions.NoSuchEntity;
import com.forum.model.entity.Users;
import com.forum.repository.UsersRepository;
import com.forum.service.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users findById(long id){
        return usersRepository.findById(id).orElseThrow(()-> new NoSuchEntity("No such id!"));
    }

    public List<Users> findAll(){
        return usersRepository.findAll();
    }

    public Users saveUser(Users users){
        return usersRepository.saveAndFlush(users);
    }

    public Users deleteById(Long id){
        Users usersFromDB = findById(id);
        usersRepository.deleteById(id);
        return usersFromDB;
    }

    public Users updateById(Users users){
        findById(users.getId());
        return saveUser(users);
    }
}
