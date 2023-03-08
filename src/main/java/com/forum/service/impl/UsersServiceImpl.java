package com.forum.service.impl;

import com.forum.exceptions.NoSuchEntity;
import com.forum.model.entity.Users;
import com.forum.repository.UsersRepository;
import com.forum.service.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users findById(long id){
        return usersRepository.findById(id).orElseThrow(()-> new NoSuchEntity("Fuck you!"));
    }

    public List<Users> findAll(){
        return usersRepository.findAll();
    }

    public Users saveUser(Users users){
        return usersRepository.saveAndFlush(users);
    }

    public Users deleteById(Long id){
        Users usersFromDB = findById(id);
        if(usersFromDB != null){
            usersRepository.deleteById(id);
        }
        return usersFromDB;
    }

    public Users updateById(Users users){
        if(findById(users.getId()) != null){
            return saveUser(users);
        } else {
            return null;
        }
        //usersRepository.findById(users.getId());
    }
}
