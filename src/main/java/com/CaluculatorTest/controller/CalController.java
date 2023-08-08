package com.CaluculatorTest.controller;

import com.CaluculatorTest.service.CaluculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
public class CalController {
    @Autowired
    private CaluculatorService caluculatorService;
    @GetMapping("/subtract")
        public String subtract(@RequestParam int num1, @RequestParam int num2) {
            return "The difference is " + (num1 - num2);
        }

        @GetMapping("/multiply/{num1}/{num2}")
        public String multiplication(@PathVariable int num1, @PathVariable int num2) {
            return "The Product of given numbers is " + (num1 * num2);
        }

        @PostMapping("/add")
        public ResponseEntity<String> addition(@RequestBody int[] numbers) {
            return new ResponseEntity<>(caluculatorService.Addition(numbers), HttpStatus.CREATED);
        }

        @GetMapping("/twodigitadd")
        public ResponseEntity<String> add(@RequestBody int num1, int num2) {
            return new ResponseEntity<>(caluculatorService.twoDigitAdd(num1, num2), HttpStatus.CREATED);
        }
}

