package com.test.quarkus.resource;

import com.test.quarkus.entity.Person;
import com.test.quarkus.service.PersonService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

/**
 *
 * @author anoop
 */
@Path("/person")
public class PersonResource {
    
    @Inject
    PersonService personService;
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/create/{name}")
    
    public List<Person> createPerson(@PathParam(value = "name") String name, @QueryParam(value = "dob") String dob) {
        personService.addPerson(name, dob);
        return personService.findAllAlivePersons();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/allAlive")
    public List<Person> findAllAlive() {
        return personService.findAllAlivePersons();
    }
    
}
