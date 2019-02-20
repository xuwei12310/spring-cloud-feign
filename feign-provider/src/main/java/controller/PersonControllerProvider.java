package controller;

import com.example.feign.model.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class PersonControllerProvider {

    private ConcurrentHashMap<Long,Person> personConcurrentHashMap=new ConcurrentHashMap<>();
    @RequestMapping("addPerson")
    public boolean addPerson(Person person) {
        return personConcurrentHashMap.put(person.getId(),person)==null;
    }

    @RequestMapping(value = "findAll")
    public Collection<Person> findAll() {
        return personConcurrentHashMap.values();
    }
}
