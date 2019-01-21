package com.acme.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockController {

    @RequestMapping("/mock")
    public String greeting() {
        return "mock1";
    }

}
