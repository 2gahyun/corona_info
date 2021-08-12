<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>코로나 정보 대시보드</title>
    <link rel="stylesheet" href="/assets/css/reset.css">
    <link rel="stylesheet" href="/assets/css/index.css">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js@3.5.0/dist/chart.min.js"></script>
    <script src="/assets/js/index.js"></script>
</head>
<body>
    <div class="container">
        <div class="left_menu">
            <a href="/" id="logo">CORONA INFO</a>
            <ul class="main_menu">
                <li>
                    <a href="#"">Overview <span>전체통계</span></a>
                </li>
                <li>
                    <a href="#">Regional <span>지역별통계</span></a>
                </li>
                <li>
                    <a href="#">Vaccine <span>백신접종현황</span></a>
                </li>
                <li>
                    <a href="#">Social Distance <span>사회적거리두기</span></a>
                </li>
                <li>
                    <a href="#">Prediction Info <span>코로나예측정보</span></a>
                </li>
            </ul>
        </div>
        <div class="dashboard_area">
        <div class="dashboard_content">
            <div class="content_left">
                <p class="con_title">검사자 수</p>
                <p class="con_number" id="accExamCnt">0</p>
                <p class="con_title">확진자 수</p>
                <p class="con_number" id="decideCnt">0</p>
            </div>
            <div class="content_right">
                <canvas id="regional_status" style="width: 100%; height: 100%;"></canvas>
            </div>
        </div>
        <div class="dashboard_content">
            <div class="content_left">
                <canvas id="confirmed_chart" style="width: 100%; height: 100%;"></canvas>
            </div>
            <div class="content_right">
                <canvas id="vaccine_chart" style="width: 100%; height: 100%;"></canvas>
            </div>
        </div>
        <div class="dashboard_content">
            <div class="content_left live_confirm_area">
                <div class="live_confirm_item">
                    <span class="time">16분 전</span>
                    <span class="region">경남 고성군</span>
                    <span class="num">2</span>명 추가확진
                </div>
                <div class="live_confirm_item">
                    <span class="time">16분 전</span>
                    <span class="region">경남 고성군</span>
                    <span class="num">2</span>명 추가확진
                </div>
            </div>
            <div class="content_right">
                <table class="region_confirm_tbl">
                    <thead>
                        <tr>
                            <td>지역</td>
                            <td>누적확진자</td>
                            <td>신규확진자</td>
                        </tr>
                    </thead>
                    
                </table>
                <div class="region_pager_area">
                    <button id="region_prev">&lt;</button>
                    <span class="current">1</span> / <span class="total">6</span>
                    <button id="region_next">&gt;</button>
                </div>
            </div>
        </div>
        <div class="dashboard_content">
            <div class="content_left">
                <canvas id="gen_chart" style="width: 100%; height: 100%;"></canvas>
            </div>
            <div class="content_right">
                <canvas id="age_chart" style="width: 100%; height: 100%;"></canvas>
            </div>
        </div>
        </div>
    </div>
</body>
</html>