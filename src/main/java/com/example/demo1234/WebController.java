package com.example.demo1234;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/sample")
    public String respone(Model theModel) {
        String name = "Pawel";
        theModel.addAttribute("name", name);
        theModel.addAttribute("theDate", new java.util.Date());
        return "hello";
    }

    // @GetMapping("/hello")
    // public String sayHello(Model theModel) {
    //
    // theModel.addAttribute("theDate", new java.util.Date());
    //
    // return "helloworld";
    // }
}
