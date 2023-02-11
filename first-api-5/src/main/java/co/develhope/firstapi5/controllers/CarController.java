package co.develhope.firstapi5.controllers;

import co.develhope.firstapi5.DTO.CarDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;

@RestController
@RequestMapping("/cars")
public class CarController {

    @GetMapping
    public CarDTO getCar() {
        return new CarDTO("1", "Model X", 100000.0);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createCar(@Valid @RequestBody CarDTO car) {
        System.out.println("Car ID: " + car.getId());
        System.out.println("Model Name: " + car.getModelName());
        System.out.println("Price: " + car.getPrice());
        return "Car created successfully";
    }
}