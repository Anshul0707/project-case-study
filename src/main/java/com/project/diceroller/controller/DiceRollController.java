package com.project.diceroller.controller;

import com.project.diceroller.common.Response;
import com.project.diceroller.exceptions.DiceServiceException;
import com.project.diceroller.service.DiceRollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class DiceRollController {

    private DiceRollService diceRollService;

    public DiceRollController(DiceRollService diceRollService) {
        this.diceRollService = diceRollService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @PostMapping("/roll")
    public ResponseEntity<Response> processRollForm(@RequestBody String expression) {
        Response response;
        try {
            int result = diceRollService.arithmeticExpression(expression);
            response = new Response();
            response.setStatus("Success");
            response.setMessage("Expression Inserted Successfully..");
        } catch (DiceServiceException e) {
            log.error("Error while Inserting Expression: {}", e.getMessage(), e);
            response = new Response();
            response.setStatus("Failure");
            response.setMessage("Error");
        }
        return ResponseEntity.ok(response);
    }
}
