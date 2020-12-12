package by.jrr.modelmapper.service;

import by.jrr.bean.Human;
import by.jrr.bean.Person;
import by.jrr.bean.UserDTO;
import by.jrr.modelmapper.config.ModelMapperConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserServiceWithModelMapperTest {

    @Autowired
    UserServiceWithModelMapper userService;

    @Test
    public void validateModelMapperConfig() {
        new ModelMapperConfig().modelMapper().validate();
    }

    @Test
    void mapPersonToUserWithMapper() {
        UserDTO userDTO = userService.mapPersonToUserWithMapper(makePerson());
        assertThat(userDTO).isEqualTo(makeUserDto());
    }

    @Test
    void mapUserToPersonWithMapper() {
        Person personFromDto = userService.mapUserToPersonWithMapper(makeUserDto());
        assertThat(personFromDto).isEqualTo(makePersonWithNullId());
    }

    @Test
    void mapUserToHumanWithMapper() {
        Human humanFromUserDto = userService.mapUserToHumanWithMapper(makeUserDto());
        assertThat(humanFromUserDto).isEqualTo(makeHuman());
    }

    private UserDTO makeUserDto() {
        return UserDTO.builder().userName("Tema").userLastName("Tank").build();
    }

    private Person makePerson() {
        return Person.builder().id(2l).name("Tema").lastName("Tank").build();
    }

    private Person makePersonWithNullId() {
        return Person.builder().id(null).name("Tema").lastName("Tank").build();
    }

    private Human makeHuman() {
        return Human.builder().humanName("Tema").humanSurname("Tank").build();
    }
}
