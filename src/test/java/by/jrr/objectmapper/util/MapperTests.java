package by.jrr.objectmapper.util;

import by.jrr.objectmapper.bean.Human;
import by.jrr.objectmapper.bean.Person;
import by.jrr.objectmapper.config.DataBaseConnection;
import by.jrr.objectmapper.model.PersonToUserMixIn;
import by.jrr.objectmapper.model.UserDTO;
import by.jrr.objectmapper.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Map;

@SpringBootTest
public class MapperTests {

    @Autowired
    UserService userService;

    @Test
    public void mapObjectToString() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Person.builder().id(2l).name("Max").lastName("Guru").build();
        String result = objectMapper.writeValueAsString(
                Person.builder().id(2l).name("Max").lastName("Guru").build()
        );
        System.out.println(result);
    }

    @Test
    public void readJsonAndMapToObject() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String asJson = ResourcesIO.readStringFromPath("person.json");
        Person result = objectMapper.readValue(asJson, Person.class);
        System.out.println(result);
    }

    @Test
    public void readDataBaseProperties() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String asJson = ResourcesIO.readStringFromPath("config.json");
        DataBaseConnection dataBaseConnection = objectMapper.readValue(asJson, DataBaseConnection.class);
        System.out.println(dataBaseConnection);
    }

    @Test
    public void readDataFromMap() {
        Map<String, Object> myMap = Map.of(
                "id", 2,
                "name", "Max",
                "lastName", "Guru",
                "databaseUrl", "localhost:3306",
                "password", 124,
                "user", "max"
        );
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.readerForMapOf(DataBaseConnection.class);
        DataBaseConnection dataBaseConnection = objectMapper.convertValue(myMap, DataBaseConnection.class);
        System.out.println(dataBaseConnection);
    }

    @Test
    public void convertPersonToUser() {
        var person = Person.builder().id(2l).name("Max").lastName("Guru").build();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.addMixIn(Person.class, PersonToUserMixIn.class);
        UserDTO user = objectMapper.convertValue(person, UserDTO.class);
        System.out.println(user);
    }

    @Test
    public void convertPersonToUserWithBean() {

        var person = Person.builder().id(2l).name("Max").lastName("Guru").build();
        UserDTO userDTO = userService.mapPersonToUserWithMapper(person);
        System.out.println(userDTO);

        var user = UserDTO.builder().userName("Tema").userLastName("Tank").build();
        Person personFromDto = userService.mapUserToPersonWithMapper(user);
        System.out.println(personFromDto);


        Human humanFromUserDto = userService.mapUserToHumanWithMapper(user);
        System.out.println(humanFromUserDto);
    }
}
