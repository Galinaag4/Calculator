package com.skypro.calculator.controller;

import com.skypro.calculator.exception.IllegalNumberException;
import com.skypro.calculator.servise.CalculatorServise;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorServise calculatorServise;

    public CalculatorController(CalculatorServise calculatorServise) {
        this.calculatorServise = calculatorServise;
    }
    @ExceptionHandler(value = IllegalNumberException.class)
    public ResponseEntity<String> illegalNumberHandler(IllegalNumberException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
    @GetMapping("/")
    public String hello(){return "Hello, Username!";}

    @GetMapping("/plus")
    public String plus(@RequestParam("num1") int num1,@RequestParam("num2") int num2){
        int result = calculatorServise.plus(num1,num2);
        return String.format("%d + %d = %d",num1,num2,result);
    }
    @GetMapping("/minus")
    public String minus(@RequestParam("num1") int num1,@RequestParam("num2") int num2){
        int result = calculatorServise.minus(num1,num2);
        return String.format("%d - %d = %d",num1,num2,result);
    }
    @GetMapping("/multiply")
    public String multiply(@RequestParam("num1") int num1,@RequestParam("num2") int num2){
        int result = calculatorServise.multiply(num1,num2);
        return String.format("%d * %d = %d",num1,num2,result);
    }
    @GetMapping("/divide")
    public String divide(@RequestParam("num1") int num1,@RequestParam("num2") int num2){
        int result = calculatorServise.divide(num1,num2);
        return String.format("%d / %d = %d",num1,num2,result);
    }


}
