package com.project;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class DiceApp implements CommandLineRunner {
    @Autowired
    Controller controller;

    public static void main(String[] args) {
        SpringApplication.run(DiceApp.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        controller.hello();
    }
}
