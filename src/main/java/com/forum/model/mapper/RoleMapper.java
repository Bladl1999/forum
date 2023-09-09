package com.forum.model.mapper;

import com.forum.model.dto.RoleDTO;
import com.forum.model.entity.Role;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface RoleMapper {

    @Mapping(target = "id", ignore = false)
    RoleDTO toDto(Role role);

    @Mapping(target = "id", ignore = false)
    Role toEntity(RoleDTO roleDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(RoleDTO roleDTO, @MappingTarget Role role);
}
