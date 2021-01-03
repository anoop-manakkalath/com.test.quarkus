package com.test.quarkus.resource;

import com.test.quarkus.entity.Person;
import com.test.quarkus.entity.Status;
import com.test.quarkus.service.PersonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    @Path("/{name}/create")
    @ApiOperation("Creates a person")
    public List<Person> createPerson(@ApiParam(value = "Name of the person", example = "Anoop") 
            @PathParam(value = "name") String name, 
            @ApiParam(value = "DOB of the person", example = "24-08-1992") @QueryParam(value = "dob") String dob,
            @ApiParam(value = "Employment status of the person", example = "Employed") @QueryParam(value = "status") String status) {
        personService.addPerson(name, dob, Status.valueOf(status));
        return personService.findAllPersons();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/allEmployed")
    @ApiOperation("List all employed persons")
    public List<Person> findAllAlive() {
        return personService.findAllEmployedPersons();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/allUnemployed")
    @ApiOperation("List all unemployed persons")
    public List<Person> findAllDead() {
        return personService.findAllUnemployedPersons();
    }
    
}
