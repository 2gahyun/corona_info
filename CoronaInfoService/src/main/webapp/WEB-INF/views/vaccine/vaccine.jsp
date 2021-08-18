<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css" integrity="sha512-aOG0c6nPNzGk+5zjwyJaoRUgCdOrfSDhmMID2u4+OIslr0GjpLKo7Xm0Ao3xmpM4T8AmIouRkqwj1nrdVsLKEQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.structure.min.css" integrity="sha512-oM24YOsgj1yCDHwW895ZtK7zoDQgscnwkCLXcPUNsTRwoW1T1nDIuwkZq/O6oLYjpuz4DfEDr02Pguu68r4/3w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.theme.min.css" integrity="sha512-9h7XRlUeUwcHUf9bNiWSTO9ovOWFELxTlViP801e5BbwNJ5ir9ua6L20tEroWZdm+HFBAWBLx2qH4l4QHHlRyg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js" integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <link rel="stylesheet" href="/assets/css/vaccine.css">
    <script src="/assets/js/vaccine.js"></script>
</head>

<body>
    <div class="container">
        <%@include file="/WEB-INF/views/includes/menu.jsp"%>
        <div class="right_area">
            <div class="data_row">
                <h1><input id="date"> 전체 백신 접종 현황</h1>
                <div class="vaccine_first">
                    <p>1차 접종</p>
                    <p><span id="accFirstCntAll">12,345,678</span><span id="incFirstCntAll">123,458 <span
                                id="th">▲</span></span></p>
                </div>
                <div class="vaccine_second">
                    <p>2차 접종</p>
                    <p><span id="accSecondCntAll">12,345,678</span><span id="incSecondCntAll">123,458 <span
                                id="th">▲</span></span></p>
                </div>
            </div>
            <div class="sido_area">
                <div class="sido_box">
                    <p class="sido_name">서울특별시</p>
                    <p class="sidoFirst">
                        <span>1차</span>
                        <span class="sidoAccCnt">1,234,567</span>
                        <span class="sidoIncCnt">12,345 <span id="th">▲</span></span>
                    </p>
                    <p class="sidoSecond">
                        <span>2차</span>
                        <span class="sidoAccCnt">1,234,567</span>
                        <span class="sidoIncCnt">12,345 <span id="th">▲</span></span>
                    </p>
                </div>
                <div class="sido_box">
                    <p class="sido_name">서울특별시</p>
                    <p class="sidoFirst">
                        <span>1차</span>
                        <span class="sidoAccCnt">1,234,567</span>
                        <span class="sidoIncCnt">12,345 <span id="th">▲</span></span>
                    </p>
                    <p class="sidoSecond">
                        <span>2차</span>
                        <span class="sidoAccCnt">1,234,567</span>
                        <span class="sidoIncCnt">12,345 <span id="th">▲</span></span>
                    </p>
                </div>
                <div class="sido_box">
                    <p class="sido_name">서울특별시</p>
                    <p class="sidoFirst">
                        <span>1차</span>
                        <span class="sidoAccCnt">1,234,567</span>
                        <span class="sidoIncCnt">12,345 <span id="th">▲</span></span>
                    </p>
                    <p class="sidoSecond">
                        <span>2차</span>
                        <span class="sidoAccCnt">1,234,567</span>
                        <span class="sidoIncCnt">12,345 <span id="th">▲</span></span>
                    </p>
                </div>
            </div>
        </div>
    </div>
</body>

</html>