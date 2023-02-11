package co.develhope.swagger2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DefaultController {

    @GetMapping("/")
    public String welcome() {
        return "Welcome to the Root Controller";
    }
}