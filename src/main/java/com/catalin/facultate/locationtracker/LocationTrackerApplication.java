package com.catalin.facultate.locationtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableReactiveMongoRepositories
@SpringBootApplication
public class LocationTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LocationTrackerApplication.class, args);
    }

}
