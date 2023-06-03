package com.project.diceroller;

import com.project.diceroller.controller.DiceRollController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@Slf4j
public class DiceApp implements CommandLineRunner {
    @Autowired
    DiceRollController diceRollController;

    public static void main(String[] args) {
        SpringApplication.run(DiceApp.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        diceRollController.hello();
        diceRollController.processRollForm("4D6 + 3D4");
    }
}
