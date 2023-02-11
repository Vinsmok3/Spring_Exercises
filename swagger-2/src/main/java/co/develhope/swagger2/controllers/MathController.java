package co.develhope.swagger2.controllers;

import co.develhope.swagger2.entities.ArithmeticOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/math")
class MathController {

    @GetMapping("")
    public String welcomeMathMsg() {
        return "Welcome to Math Controller";
    }

    @GetMapping("division-info")
    public ArithmeticOperation divisionInfo() {
        ArithmeticOperation division = new ArithmeticOperation();
        division.setName("division");
        division.setMinNumberOfOperands(2);
        division.setDescription("Performs the division between two numbers");
        division.getProperties().add("divides two numbers");
        division.getProperties().add("returns a decimal number");

        return division;
    }

    @GetMapping("multiplication")
    public int multiplication(@RequestParam int a, @RequestParam int b) {
        return a * b;
    }

    @GetMapping("square/{n}")
    public int square(@PathVariable int n) {
        return n * n;
    }
}
