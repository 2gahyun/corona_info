package com.greenart.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import com.greenart.service.RegionalInfoService;
import com.greenart.vo.CoronaInfoVO;
import com.greenart.vo.SidoInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegionalAPIController {
    @Autowired RegionalInfoService service;

    @GetMapping("/api/regional")
    public Map<String ,Object> getRegionalInfo(@RequestParam @Nullable String region, @RequestParam @Nullable String date){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        
        if(date == null) {
            Date now = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = formatter.format(now);
        }
        SidoInfoVO vo =  service.selectRegionalCoronaInfo(region, date);
        resultMap.put("data", vo);
        return resultMap;
    }
}
