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
                <p class="con_number">12,057,831</p>
                <p class="con_title">확진자 수</p>
                <p class="con_number">212,488</p>
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
            <div class="content_left"></div>
            <div class="content_right"></div>
        </div>
        </div>
    </div>
</body>
</html>