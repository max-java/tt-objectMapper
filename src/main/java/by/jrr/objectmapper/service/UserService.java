package by.jrr.objectmapper.service;

import by.jrr.objectmapper.bean.Human;
import by.jrr.objectmapper.bean.Person;
import by.jrr.objectmapper.model.UserDTO;
import by.jrr.objectmapper.repository.PersonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    @Qualifier("personToUserMapper")
    ObjectMapper personToUserMapper;
    @Autowired
    @Qualifier("userToPersonMapper")
    ObjectMapper userToPersonMapper;
    @Autowired
    @Qualifier("userToHumanMapper")
    ObjectMapper userToHumanMapper;

    public UserDTO getUserById(long id) {
        Person person = personRepository.findPersonById(id);
        return mapPersonToUser(person);

    }

    private UserDTO mapPersonToUser(Person person) {
        UserDTO user = new UserDTO();
        user.setUserName(person.getName());
        user.setUserLastName(person.getLastName());
        return user;
    }

    public UserDTO mapPersonToUserWithMapper(Person person) {
        return personToUserMapper.convertValue(person, UserDTO.class);
    }

    public Person mapUserToPersonWithMapper(UserDTO userDTO) {
        return userToPersonMapper.convertValue(userDTO, Person.class);
    }

    public Human mapUserToHumanWithMapper(UserDTO userDTO) {
        return userToHumanMapper.convertValue(userDTO, Human.class);
    }
}
