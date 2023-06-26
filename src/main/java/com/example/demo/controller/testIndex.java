package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class testIndex {

    @GetMapping("/index")
    public ModelAndView index(){
        System.out.println(123);

        return new ModelAndView("index");
    }

    @GetMapping("/Xss")
    public void xssTest(@RequestParam String member){

        System.out.println(member);

    }


}
