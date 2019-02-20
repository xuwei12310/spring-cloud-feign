package service.impl;

import com.example.feign.model.Person;
import com.example.feign.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class PersonServiceImpl implements PersonService {
    PersonService personService;

    @Autowired
    public PersonServiceImpl(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public boolean addPerson(Person person) {
        return personService.addPerson(person);
    }

    @Override
    public Collection<Person> findAll() {
        return personService.findAll();
    }
}
