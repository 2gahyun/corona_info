package com.greenart.service;

import com.greenart.mapper.RegionalInfoMapper;
import com.greenart.vo.CoronaInfoVO;
import com.greenart.vo.SidoInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionalInfoService {
    @Autowired RegionalInfoMapper mapper;
    public SidoInfoVO selectRegionalCoronaInfo(String region, String date){
        return mapper.selectRegionalCoronaInfo(region, date);
    }

    public CoronaInfoVO selectCoronaInfoRegionTotal(String date){
        return mapper.selectCoronaInfoRegionTotal(date);
    }
}
