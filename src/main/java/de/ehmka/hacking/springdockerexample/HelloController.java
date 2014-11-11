package de.ehmka.hacking.springdockerexample;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by michi on 11/11/14.
 */

@RestController
public class HelloController {

    private AtomicLong atomicLong = new AtomicLong();

    @RequestMapping("/")
    public String index() {
        return "Greetings from spring boot";
    }

    @RequestMapping(method = RequestMethod.GET)
    public  @ResponseBody Greeting sayHello(@RequestParam(value = "name", required = false, defaultValue = "Stranger") String name) {
        return new Greeting(atomicLong.incrementAndGet(), name);
    }
}
