package com.greenart.service;

import java.util.List;

import com.greenart.mapper.RegionalInfoMapper;
import com.greenart.vo.CoronaInfoVO;
import com.greenart.vo.CoronaWeeksVO;
import com.greenart.vo.SidoInfoVO;
import com.greenart.vo.VaccineInfoVO;
import com.greenart.vo.VaccineWeeksVO;

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

    public VaccineInfoVO selectCoronVaccineInfo(String region, String date){
        return mapper.selectCoronVaccineInfo(region, date);
    }

    public String selectDangerAge(String date){
        return mapper.selectDangerAge(date);
    }

    public List<CoronaWeeksVO> selectRegionalCoronaTwoWeeks(String region, String date){
        return mapper.selectRegionalCoronaTwoWeeks(region, date);
    }

    public List<VaccineWeeksVO> selectVaccineCoronaTwoWeeks(String region, String date){
        return mapper.selectVaccineCoronaTwoWeeks(region, date);
    }
}
