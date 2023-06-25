package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class testIndex {

    @GetMapping("/index")
    public ModelAndView index(){
        System.out.println(123);

        return new ModelAndView("index");
    }

    @GetMapping("/Xss/{member}")
    public void xssTest(@PathVariable String member){

        System.out.println(member);
        System.out.println("&lt;");
    }


}
