package co.develhope.deploy1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @GetMapping("/devName")
    public String getDevName() {
        return "Your name";
    }
}