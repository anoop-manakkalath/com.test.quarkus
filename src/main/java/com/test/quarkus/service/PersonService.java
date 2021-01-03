package com.test.quarkus.service;

import com.test.quarkus.entity.Person;
import com.test.quarkus.entity.Status;
import com.test.quarkus.repository.PersonRepository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author anoop
 */
@ApplicationScoped
public class PersonService {
    
    @Inject
    PersonRepository personRepository;
    
    @Transactional
    public void addPerson(String name, String dob, Status status) {
        Integer date = Integer.valueOf(dob.split("-")[0]);
        Month month = Month.of(Integer.valueOf(dob.split("-")[1]));
        Integer year = Integer.valueOf(dob.split("-")[2]);
        Person p = new Person(null, name, LocalDate.of(year, month, date), status);
        personRepository.createPerson(p);
    }
    
    public List<Person> findAllPersons() {
        return personRepository.findAllPersons();
    }
    
    public List<Person> findAllEmployedPersons() {
        return personRepository.findAllEmployedPersons();
    }
    
    public List<Person> findAllUnemployedPersons() {
        return personRepository.findAllUnemployedPersons();
    }
}
