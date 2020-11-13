package com.test.quarkus.service;

import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author anoop
 */
@ApplicationScoped
public class GreetingService {

    public String greeting(String name) {
        return "hello " + name;
    }
}
