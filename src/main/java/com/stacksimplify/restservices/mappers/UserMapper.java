package com.stacksimplify.restservices.mappers;

import com.stacksimplify.restservices.dtos.UserMsDto;
import com.stacksimplify.restservices.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    //User to UserMsDto
    @Mappings({
    @Mapping(source = "role", target = "rolename"),
    @Mapping(source = "email", target = "emailaddress")
    })
    UserMsDto userToUserMsDto(User user);

    //List<User> to List<UserMsDto>
    List<UserMsDto> userToUserMsDtos(List<User> users);
}
