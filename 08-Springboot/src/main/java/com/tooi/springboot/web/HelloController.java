package com.tooi.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model m) throws Exception {
        m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        if (false){
            throw new Exception("some exception");
        }
        return "hello";
    }

    @RequestMapping("/helloThymeleaf")
    public String helloThymeleaf(Model m){
        m.addAttribute("name","thymeleaf");
        return "helloThymeleaf";
    }
}
