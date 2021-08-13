package com.greenart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegionalController {
    @GetMapping("/regional")
    public String getRegional(){
        return "/regional/regional";
    }
}
