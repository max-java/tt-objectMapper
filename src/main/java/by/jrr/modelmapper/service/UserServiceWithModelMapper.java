package by.jrr.modelmapper.service;

import by.jrr.bean.Human;
import by.jrr.bean.Person;
import by.jrr.bean.UserDTO;
import by.jrr.objectmapper.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceWithModelMapper {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    ModelMapper mapper;

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
        UserDTO result = mapper.map(person, UserDTO.class);
        return result;
    }

    public Person mapUserToPersonWithMapper(UserDTO userDTO) {
        return mapper.map(userDTO, Person.class);
    }

    public Human mapUserToHumanWithMapper(UserDTO userDTO) {
        return mapper.map(userDTO, Human.class);
    }
}
