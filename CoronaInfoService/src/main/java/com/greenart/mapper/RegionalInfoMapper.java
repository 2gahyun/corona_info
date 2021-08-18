package com.greenart.mapper;

import java.util.List;

import com.greenart.vo.CoronaInfoVO;
import com.greenart.vo.CoronaWeeksVO;
import com.greenart.vo.SidoInfoVO;
import com.greenart.vo.VaccineInfoVO;
import com.greenart.vo.VaccineWeeksVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegionalInfoMapper {
    public SidoInfoVO selectRegionalCoronaInfo(String region, String date);
    public CoronaInfoVO selectCoronaInfoRegionTotal(String date);
    public VaccineInfoVO selectCoronVaccineInfo(String region, String date);
    public String selectDangerAge(String date);
    public List<CoronaWeeksVO> selectRegionalCoronaTwoWeeks(String region, String date);
    
    public List<VaccineWeeksVO> selectVaccineCoronaTwoWeeks(String region, String date);
    public List<VaccineWeeksVO> selectVaccineInfo(String date);
}
