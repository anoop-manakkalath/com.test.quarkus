package com.test.quarkus.entity;

/**
 *
 * @author anoop
 */
public enum Status {
    
    Employed("Employed"),
    Unemployed("Unemployed");
    
    private final String value;
    
    Status(String value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return value;
    }
    
}
