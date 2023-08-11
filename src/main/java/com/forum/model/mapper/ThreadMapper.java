package com.forum.model.mapper;

import com.forum.model.dto.ThreadDTO;
import com.forum.model.entity.Thread;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ThreadMapper {

    @Mapping(target = "id", ignore = false)
    ThreadDTO toDto(Thread thread);

    @Mapping(target = "id", ignore = false)
    Thread toEntity(ThreadDTO threadDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(ThreadDTO threadDTO, @MappingTarget Thread thread);
}
