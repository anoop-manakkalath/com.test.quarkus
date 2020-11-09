package com.test.quarkus;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

/**
 *
 * @author anoop
 */
@QuarkusMain
public class Main {

    public static void main(String... args) {
        System.out.println("Starting the service...");
        Quarkus.run(args);
        System.out.println("Successfully sarted the service.");
    }
}
