package com.Infinity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/test1")
    public String test() {

        System.out.println("666");

        return "welcome";
    }
}