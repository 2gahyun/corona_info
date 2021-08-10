package com.greenart.vo;

import java.util.Date;

import lombok.Data;

@Data
public class CoronaInfoVO {
    private Integer seq;
    private Integer accExamCnt;
    private Integer accExamCompCnt;
    private Integer careCnt;
    private Integer clearCnt;
    private Integer deathCnt;
    private Integer decideCnt;
    private Integer examCnt;
    private Integer resultNegCnt;
    private Date stateTime;

    private String strAccExamCnt;
    private String strDecideCnt;
}
