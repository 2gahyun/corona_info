package com.greenart.vo;

import java.util.Date;

import lombok.Data;

@Data
public class VaccineInfoVO {
    private Integer seq;
    private Integer accFirstCnt;
    private Integer accSecondCnt;
    private Date regDt;
    private Integer fistCnt;
    private Integer secondCnt;
    private String sido;
}
