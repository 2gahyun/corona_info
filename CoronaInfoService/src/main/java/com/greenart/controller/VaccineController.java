package com.greenart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VaccineController {
    @GetMapping("/vaccine")
    public String getVaccine(){
        return "/vaccine/vaccine";
    }
}
