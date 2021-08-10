package com.greenart.controller;

import com.greenart.service.CoronaInfoService;
import com.greenart.vo.CoronaInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired CoronaInfoService service;

    @GetMapping("/")
    public String getMain(Model model){
        // CoronaInfoVO vo = service.selectTodayCoronaInfo();
        // model.addAttribute("coronaInfo", vo);

        return "/index";
    }
}
