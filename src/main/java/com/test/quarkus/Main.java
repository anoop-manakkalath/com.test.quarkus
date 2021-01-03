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
        Quarkus.run(args);
        System.out.println("Successfully started the service.");
    }
}
