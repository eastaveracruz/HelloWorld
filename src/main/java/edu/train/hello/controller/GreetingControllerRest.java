package edu.train.hello.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.train.hello.model.Greeting;

@RestController
public class GreetingControllerRest {

    private static final String template = "Hello, rest %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greetingrest")
    public Greeting greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}