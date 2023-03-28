package co.develhope.deploy2;

import java.util.Random;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @GetMapping("/random-sum")
    public int getRandomSum() {
        Random rand = new Random();
        int a = rand.nextInt(100);
        int b = rand.nextInt(100);
        return a + b;
    }
}