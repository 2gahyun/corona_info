package com.greenart.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.greenart.mapper.CoronaInfoMapper;
import com.greenart.vo.CoronaInfoVO;
import com.greenart.vo.SidoInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoronaInfoService {
    @Autowired CoronaInfoMapper mapper;
    public void insertCoronaInfo(CoronaInfoVO vo){
        mapper.insertCoronaInfo(vo);
    }

    public void insertCoronaSidoInfo(SidoInfoVO vo){
        mapper.insertCoronaSidoInfo(vo);
    }

    public List<SidoInfoVO> selectTodaySidoInfo(){
        Calendar now = Calendar.getInstance();
        Calendar standard = Calendar.getInstance();
        standard.set(Calendar.HOUR_OF_DAY, 10);
        standard.set(Calendar.MINUTE, 30);
        standard.set(Calendar.SECOND, 10);

        if(now.getTimeInMillis() < standard.getTimeInMillis()){
            // 현재 접속시간이 기준시간 (10시 30분 10초) 보다 이전일 때
            // 하루 이전 날짜로 변경
            now.add(Calendar.DATE, -1);
            
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dt = formatter.format(now.getTime());

        return mapper.selectSidoInfoByDate(dt);
    }

    public List<SidoInfoVO> selectSidoInfo(String date) {
        return mapper.selectSidoInfoByDate(date);
    }

    public CoronaInfoVO selectTodayCoronaInfo(){
        // Calendar start = Calendar.getInstance();
        // Calendar end = Calendar.getInstance();
        
        // start.set(Calendar.HOUR_OF_DAY, 10);
        // start.set(Calendar.MINUTE, 30);
        // start.set(Calendar.SECOND, 0);
        
        // 2021-08-11 01:00:00 - 접속시간(이전)
        // 2021-08-11 10:30:00 - 세팅값
        // 2021-08-11 14:00:00 - 접속시간(나중)
        // 현재시간이 세팅값보다 이전이라면, 전 날 데이터를 뽑아주고
        // 현재시간이 세팅값보다 나중이라면, 오늘 데이터를 뽑아준다.

        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = formatter.format(now);

        CoronaInfoVO data = mapper.selectCoronaInfoByDate(date);

        Integer accExamCnt = data.getAccExamCnt();
        Integer decideCnt = data.getDecideCnt();

        DecimalFormat dFormatter = new DecimalFormat("###,###");
        String strAccExamCnt = dFormatter.format(accExamCnt);
        String strDecideCnt = dFormatter.format(decideCnt);

        data.setStrAccExamCnt(strAccExamCnt);
        data.setStrDecideCnt(strDecideCnt);

        return data;

        // 10시 30분에 데이터 업데이트 - 10시 29분까지 이전 날의 데이터를 표시해야함
    }
}
