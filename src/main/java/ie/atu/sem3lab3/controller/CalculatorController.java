package ie.atu.sem3lab3.controller;

import ie.atu.sem3lab3.CalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calc")
public class CalculatorController {
    //Here I'm letting know to Spring Boot the class that I'm going to use.
    //CalculatorService is my class, calculatorService is my instance
    private final CalculatorService calculatorService;
    //Here Spring Boot is making a constructor for the instance of the class calculator
    //And it returns the object to me.
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
    //Here I'm receiving the data/https requests and calling the function inside my class and returning the value
    @GetMapping("/add")
    public ResponseEntity<Integer> add(@RequestParam int a, @RequestParam int b) {
        int result = calculatorService.add(a, b);
        return ResponseEntity.ok(result);
    }
    //Here I use ? because I don't know what the response form the user will be
    //In case that the user tries to divide by 0 we send a message error
    @GetMapping("/divide")
    public ResponseEntity<?> divide(@RequestParam int a, @RequestParam int b) {
        if (b==0)
        {

            return ResponseEntity.badRequest().body("Division by zero is not allowed");
        }
        int result = calculatorService.divide(a, b);
        return ResponseEntity.ok(result);
    }
}
