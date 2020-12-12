package by.jrr.objectmapper.repository;

import by.jrr.bean.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonRepository {

    public Person findPersonById(long id) {
        return new Person();
    }
}
