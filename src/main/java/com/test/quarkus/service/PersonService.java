package com.test.quarkus.service;

import com.test.quarkus.entity.Person;
import com.test.quarkus.entity.Status;
import com.test.quarkus.repository.PersonRepository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 *
 * @author anoop
 */
@ApplicationScoped
public class PersonService {
    
    @Inject
    private PersonRepository personRepository;
    
    public void addPerson(String name, String dob) {
        Integer year = Integer.valueOf(dob.split("-")[0]);
        Month month = Month.of(Integer.valueOf(dob.split("-")[1]));
        Integer date = Integer.valueOf(dob.split("-")[2]);
        Person p = new Person(null, name, LocalDate.of(year, month, date), Status.Alive);
        personRepository.create(p);
    }
        
    public List<Person> findAllAlivePersons() {
        return personRepository.findAlive();
    }
}
