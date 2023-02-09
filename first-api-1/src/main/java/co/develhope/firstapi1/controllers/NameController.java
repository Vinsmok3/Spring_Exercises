package co.develhope.firstapi1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class NameController {

    @GetMapping("/name")
    public String getName() {
        return "John";
    }

    @PostMapping("/name")
    public String postName(@RequestBody String name) {
        return new StringBuilder(name).reverse().toString();
    }


}