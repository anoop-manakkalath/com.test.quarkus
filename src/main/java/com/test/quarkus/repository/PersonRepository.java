package com.test.quarkus.repository;

import com.test.quarkus.entity.Person;
import com.test.quarkus.entity.Status;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

/**
 *
 * @author anoop
 */
@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {

    @Override
    public Optional<Person> findByIdOptional(Long id) {
        return findByIdOptional(id);
    }

    public List<Person> findByName(String name) {
        return list("name", name);
    }

    public List<Person> findAlive() {
        return list("status", Status.Alive);
    }

    @Override
    public boolean deleteById(Long id) {
        return deleteById(id);
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
