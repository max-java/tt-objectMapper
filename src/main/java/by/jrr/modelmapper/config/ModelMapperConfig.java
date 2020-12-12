package by.jrr.modelmapper.config;

import by.jrr.bean.Human;
import by.jrr.bean.Person;
import by.jrr.bean.UserDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        final ModelMapper mapper = new ModelMapper();

        final TypeMap<Person, UserDTO> personUserDTOTypeMap = mapper.createTypeMap(Person.class, UserDTO.class);
        personUserDTOTypeMap.addMapping(Person::getName, UserDTO::setUserName);
        personUserDTOTypeMap.addMapping(Person::getLastName, UserDTO::setUserLastName);

        final TypeMap<UserDTO, Person> userDTOPersonTypeMap = mapper.createTypeMap(UserDTO.class, Person.class);
        userDTOPersonTypeMap.addMapping(UserDTO::getUserName, Person::setName);
        userDTOPersonTypeMap.addMapping(UserDTO::getUserLastName, Person::setLastName);
        userDTOPersonTypeMap.addMappings(m -> m.skip(Person::setId));

        final TypeMap<UserDTO, Human> userDTOHumanTypeMap = mapper.createTypeMap(UserDTO.class, Human.class);
        userDTOHumanTypeMap.addMapping(UserDTO::getUserName, Human::setHumanName);
        userDTOHumanTypeMap.addMapping(UserDTO::getUserLastName, Human::setHumanSurname);

        return mapper;
    }
}
