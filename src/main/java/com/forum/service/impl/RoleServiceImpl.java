package com.forum.service.impl;

import com.forum.model.dto.RoleDTO;
import com.forum.model.mapper.RoleMapper;
import com.forum.repository.RoleRepository;
import com.forum.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public List<RoleDTO> findUsersByRole(UUID id) {
        //        return threadRepository.findAll().stream().map(threadMapper::toDto).collect(Collectors.toList());
//        return roleRepository.findUsersByRole(id).stream().map(roleMapper::toDto).collect(Collectors.toList());
        return null;
    }
}
