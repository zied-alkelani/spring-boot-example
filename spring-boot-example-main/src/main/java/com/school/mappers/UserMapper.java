package com.school.mappers;

import com.school.model.UserEntity;
import com.school.model.UserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserRequest mapRequest(UserEntity entity);
    @Mapping(source = "request",target = ".")
    UserEntity mapEntity(UserRequest request);
    void updateEntityFromRequest(@MappingTarget UserEntity entity, UserRequest request);
}
