package by.jrr.objectmapper.config;

import by.jrr.objectmapper.bean.Person;
import by.jrr.objectmapper.model.UserDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class Mappers {

    @Primary
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper;
    }

    @Bean(name = "personToUserMapper")
    public ObjectMapper objectPtU() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.addMixIn(Person.class, PersonToUserMixInInner.class);

        return objectMapper;
    }

    @Bean(name = "userToPersonMapper")
    public ObjectMapper objectUtP() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.addMixIn(UserDTO.class, UserToPersonMixInInner.class);
        return objectMapper;
    }

    @Bean(name = "userToHumanMapper")
    public ObjectMapper objectUtH() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.addMixIn(UserDTO.class, UserToHumanMixInInner.class);

        return objectMapper;
    }

    public abstract class PersonToUserMixInInner {

        @JsonProperty("userName")
        String name;

        @JsonProperty("userLastName")
        String lastName;
    }

    public abstract class UserToPersonMixInInner {

        @JsonProperty("name")
        String userName;

        @JsonProperty("lastName")
        String userLastName;
    }

    public abstract class UserToHumanMixInInner {

        @JsonProperty("humanName")
        String userName;

        @JsonProperty("humanSurname")
        String userLastName;
    }
}
