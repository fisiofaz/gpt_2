package br.com.gtp.users.application.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import br.com.gtp.users.application.dto.request.CreateUserRequest;
import br.com.gtp.users.application.dto.request.UpdateUserRequest;
import br.com.gtp.users.application.dto.response.UserResponse;
import br.com.gtp.users.domain.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(CreateUserRequest request);

    UserResponse toResponse(User entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(UpdateUserRequest request, @MappingTarget User entity);

}