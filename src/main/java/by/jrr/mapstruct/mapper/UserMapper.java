package by.jrr.mapstruct.mapper;

import by.jrr.objectmapper.bean.Human;
import by.jrr.objectmapper.bean.Person;
import by.jrr.objectmapper.model.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper OF = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "userName", target = "name")
    @Mapping(source = "userLastName", target = "lastName")
    Person getPersonFromUserDto(UserDTO userDTO);

    @Mapping(source = "userName", target = "humanName")
    @Mapping(source = "userLastName", target = "humanSurname")
    Human getHumanFromUserDto(UserDTO userDTO);
}
