package com.test.quarkus.repository;

import com.test.quarkus.entity.Person;
import com.test.quarkus.entity.Status;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

/**
 *
 * @author anoop
 */
@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {

    public Person findByName(String name) {
        return find("name", name).firstResult();
    }

    public List<Person> findAlive() {
        return list("status", Status.Alive);
    }

    public void deleteStefs() {
        delete("name", "Stef");
    }

    @Transactional
    public void create(Person person) {
        persistAndFlush(person);
    }
    
    @Transactional
    public void createAll(List<Person> persons) {
        persist(persons);
        flush();
    }
}
