package com.greenart.mapper;

import java.util.List;

import com.greenart.vo.CoronaAgeInfoVO;
import com.greenart.vo.CoronaInfoVO;
import com.greenart.vo.SidoInfoVO;
import com.greenart.vo.VaccineInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CoronaInfoMapper {
    public void insertCoronaInfo(CoronaInfoVO vo);
    public CoronaInfoVO selectCoronaInfoByDate(String date);

    public void insertCoronaSidoInfo(SidoInfoVO vo);
    public List<SidoInfoVO> selectSidoInfoByDate(String date);

    public void insertCoronaAgeInfo(CoronaAgeInfoVO vo);
    public List<CoronaAgeInfoVO> selectCoronaAgeInfo(String date);
    public List<CoronaAgeInfoVO> selectCoronaGenInfo(String date);

    public void insertCoronaVaccineInfo(VaccineInfoVO vo);
    public List<VaccineInfoVO> selectCoronaVaccineInfo(String date);
}
