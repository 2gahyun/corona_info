package com.greenart.vo;

import java.util.Date;

import lombok.Data;

@Data
public class SidoInfoVO {
    private Date createDt;
    private Integer deathCnt;
    private Integer defCnt;
    private String gubun;
    private Integer incDec;
    private Integer isolClearCnt;
    private Integer isolIngCnt;
    private Integer localOccCnt;
    private Integer overFlowCnt;
}
