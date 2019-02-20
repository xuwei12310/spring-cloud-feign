package com.example.feign.service;

import com.example.feign.model.Person;

import java.util.Collection;
import java.util.Collections;

/**
 * 自定义fallback
 */
public class PersonServiceFallBack implements PersonService{
    @Override
    public boolean addPerson(Person person) {
        return false;
    }

    @Override
    public Collection<Person> findAll() {
        return Collections.emptyList();
    }
}
