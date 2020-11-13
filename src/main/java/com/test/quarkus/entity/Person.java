package com.test.quarkus.entity;

import com.test.quarkus.entity.Status;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author anoop
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Person {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;
    private LocalDate birth;
    private Status status;
}
