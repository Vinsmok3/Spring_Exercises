package co.develhope.swagger.controllers;



import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Name Controller", description = "Returns your name")
public class NameController {

    @GetMapping("/name")
    public String getName() {
        return "John Doe";
    }
}