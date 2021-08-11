package com.greenart.mapper;

import java.util.List;

import com.greenart.vo.CoronaAgeInfoVO;
import com.greenart.vo.CoronaInfoVO;
import com.greenart.vo.SidoInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CoronaInfoMapper {
    public void insertCoronaInfo(CoronaInfoVO vo);
    public CoronaInfoVO selectCoronaInfoByDate(String date);

    public void insertCoronaSidoInfo(SidoInfoVO vo);
    public List<SidoInfoVO> selectSidoInfoByDate(String date);

    public void insertCoronaAgeInfo(CoronaAgeInfoVO vo);
    public CoronaAgeInfoVO selectCoronaAgeInfo(String date);
}
