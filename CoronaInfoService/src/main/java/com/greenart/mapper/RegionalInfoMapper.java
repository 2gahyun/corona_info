package com.greenart.mapper;

import com.greenart.vo.CoronaInfoVO;
import com.greenart.vo.SidoInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegionalInfoMapper {
    public SidoInfoVO selectRegionalCoronaInfo(String region, String date);
    public CoronaInfoVO selectCoronaInfoRegionTotal(String date);
    
}
