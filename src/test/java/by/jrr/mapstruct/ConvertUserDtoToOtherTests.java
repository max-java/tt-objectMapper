package by.jrr.mapstruct;

import by.jrr.mapstruct.mapper.UserMapper;
import by.jrr.objectmapper.bean.Human;
import by.jrr.objectmapper.bean.Person;
import by.jrr.objectmapper.model.UserDTO;
import org.junit.jupiter.api.Test;

public class ConvertUserDtoToOtherTests {

    @Test
    public void convertPersonToUserWithBean() {


        var user = UserDTO.builder().userName("Tema").userLastName("Tank").build();
        Person personFromDto = UserMapper.OF.getPersonFromUserDto(user);
        System.out.println(personFromDto);


        Human humanFromUserDto = UserMapper.OF.getHumanFromUserDto(user);
        System.out.println(humanFromUserDto);
    }
}
