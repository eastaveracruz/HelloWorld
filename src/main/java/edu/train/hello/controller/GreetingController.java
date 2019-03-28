package edu.train.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller(value = "greeting")
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        String message = "I am presenting spring mvc";
        model.addAttribute("message", message);
        return "greeting";
    }

    @GetMapping("/jquery")
    public String greetingJQuery(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        String message = "I am presenting spring mvc";
        model.addAttribute("message", message);
        return "jquery";
    }

}