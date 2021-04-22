package com.minty.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CounterController {
    @GetMapping(value = "/getcounter")
    public String getCounter() {
        String str = Integer.toString(CopyCounter.getCounter()) + " запросов было выполнено";
        return str;
    }
}
