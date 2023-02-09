package co.develhope.firstapi1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class FirstApi1Application {

    public static void main(String[] args) {
        SpringApplication.run(FirstApi1Application.class, args);
    }

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
}