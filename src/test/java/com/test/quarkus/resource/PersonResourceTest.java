package com.test.quarkus.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import com.test.quarkus.entity.Person;
import com.test.quarkus.entity.Status;
import com.test.quarkus.service.PersonService;

import java.time.LocalDate;
import java.time.Month;
import org.mockito.Mockito;

/**
 *
 * @author anoop
 */
@QuarkusTest
public class PersonResourceTest {
    
    @InjectMock
    PersonService personService;
    
    @Test
    public void testCreatePersonEndpoint() {
    	String uuid = UUID.randomUUID().toString();
        List<Person> persons = List.of(new Person(1L, uuid, LocalDate.of(2020, Month.APRIL, 1), Status.Employed));
        Mockito.doNothing().when(personService).addPerson(Mockito.any(), Mockito.any(), Mockito.any());
        Mockito.doReturn(persons).when(personService).findAllPersons();
        given()
                .pathParam("name", uuid)
                .queryParam("dob", "06-05-1982")
                .queryParam("status", "Employed")
                .when().post("/person/{name}/create")
                .then()
                .statusCode(200)
                .body("$.size()", is(1), "[0].name", is(uuid));
    }
}
