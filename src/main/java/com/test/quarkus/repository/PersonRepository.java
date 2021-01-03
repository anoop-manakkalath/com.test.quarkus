package com.test.quarkus.repository;

import com.test.quarkus.entity.Person;
import com.test.quarkus.entity.Status;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author anoop
 */
@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {

    public Optional<Person> findPersonByIdOptional(Long id) {
        return findByIdOptional(id);
    }

    public List<Person> findPersonByName(String name) {
        return list("name", name);
    }
    
    public List<Person> findAllPersons() {
        return listAll();
    }

    public List<Person> findAllEmployedPersons() {
        return list("status", Status.Employed);
    }
    
    public List<Person> findAllUnemployedPersons() {
        return list("status", Status.Unemployed);
    }

    public boolean deletePersonById(Long id) {
        return deleteById(id);
    }
    
    public void deleteAllPersons(List<Person> persons) {
        delete("DELETE FROM Person WHERE p.id IN ?1", persons);
    }

    public void createPerson(Person person) {
        persistAndFlush(person);
    }
    
    public void createAllPersons(List<Person> persons) {
        persist(persons);
    }
}
