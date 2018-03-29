package com.digitalcrafts.syntel.controller;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitalcrafts.syntel.model.Lookup;


@RestController
public class LookupController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/lookup")
    public Lookup lookup(@RequestParam(value="name", defaultValue="World") String name) {
        return new Lookup(counter.incrementAndGet(),
                            String.format(template, name));
    }
}