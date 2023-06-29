package com.forum.model.mapper;

import com.forum.model.dto.UsersDTO;
import com.forum.model.entity.Users;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UsersMapper {
    @Mapping(target = "id", ignore = false)
    UsersDTO toDto(Users users);

    @Mapping(target = "id", ignore = false)
    Users toEntity(UsersDTO usersDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(UsersDTO usersDTO, @MappingTarget Users users);
}
