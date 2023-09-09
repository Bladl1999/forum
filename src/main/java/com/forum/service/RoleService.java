package com.forum.service;

import com.forum.model.dto.RoleDTO;

import java.util.List;
import java.util.UUID;

public interface RoleService {

//    RoleDTO findById(UUID id);
//
//    List<RoleDTO> findAll();
//
//    RoleDTO saveRole(RoleDTO roleDTO);
//
//    RoleDTO deleteById(UUID id);
//
//    RoleDTO update(RoleDTO roleDTO);

    List<RoleDTO> findUsersByRole(UUID id);

}
