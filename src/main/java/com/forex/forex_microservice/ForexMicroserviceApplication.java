package com.forex.forex_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ForexMicroserviceApplication {
    //java -jar forex_microservice-0.0.1-SNAPSHOT.jar --server.port=8000
    public static void main(String[] args) {
        SpringApplication.run(ForexMicroserviceApplication.class, args);
    }
}
