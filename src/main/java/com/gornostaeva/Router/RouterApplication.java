package com.gornostaeva.Router;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RouterApplication {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a path to a route file in command line arguments (routeFilePath={path})");
            System.exit(0);
        }
        SpringApplication.run(RouterApplication.class, args);
    }
}
