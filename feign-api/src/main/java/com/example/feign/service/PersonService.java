package com.example.feign.service;

import com.example.feign.model.Person;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@FeignClient(value = "person-service",fallback = PersonServiceFallBack.class)
public interface PersonService {

    @RequestMapping("addPerson")
    public boolean addPerson(Person person);

    @RequestMapping("findAll")
    public Collection<Person> findAll();
}
