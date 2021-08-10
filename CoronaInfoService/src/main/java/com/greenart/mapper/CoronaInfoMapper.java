package com.greenart.mapper;

import com.greenart.vo.CoronaInfoVO;
import com.greenart.vo.SidoInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CoronaInfoMapper {
    public void insertCoronaInfo(CoronaInfoVO vo);
    public CoronaInfoVO selectCoronaInfoByDate(String date);

    public void insertCoronaSidoInfo(SidoInfoVO vo);
    public SidoInfoVO selectSidoInfoByDate(String date);
}
