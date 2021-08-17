<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css" integrity="sha512-aOG0c6nPNzGk+5zjwyJaoRUgCdOrfSDhmMID2u4+OIslr0GjpLKo7Xm0Ao3xmpM4T8AmIouRkqwj1nrdVsLKEQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.structure.min.css" integrity="sha512-oM24YOsgj1yCDHwW895ZtK7zoDQgscnwkCLXcPUNsTRwoW1T1nDIuwkZq/O6oLYjpuz4DfEDr02Pguu68r4/3w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.theme.min.css" integrity="sha512-9h7XRlUeUwcHUf9bNiWSTO9ovOWFELxTlViP801e5BbwNJ5ir9ua6L20tEroWZdm+HFBAWBLx2qH4l4QHHlRyg==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    <link rel="stylesheet" href="/assets/css/regional.css">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js@3.5.0/dist/chart.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js" integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

    <script src="/assets/js/regional.js"></script>
</head>
<body>
    <div class="container">
        <%@include file="/WEB-INF/views/includes/menu.jsp"%>
        <div class="right_area">
            <div class="content_head">
                <select id="region_select">
                    <option value="서울">서울특별시</option>
                    <option value="경기">경기도</option>
                    <option value="대전">대전광역시</option>
                    <option value="대구">대구광역시</option>
                    <option value="부산">부산광역시</option>
                    <option value="울산">울산광역시</option>
                    <option value="광주">광주광역시</option>
                    <option value="인천">인천광역시</option>
                    <option value="경북">경상북도</option>
                    <option value="경남">경상남도</option>
                    <option value="전북">전라북도</option>
                    <option value="전남">전라남도</option>
                    <option value="충북">충청북도</option>
                    <option value="충남">충청남도</option>
                    <option value="강원">강원도</option>
                    <option value="세종">세종특별자치시</option>
                    <option value="제주">제주특별자치도</option>
                    <option value="검역">검역소</option>
                </select>
                <span class="social_distance">
                    <span>사회적 거리두기 단계 : </span>
                    <span class="distance_level">3단계</span>
                </span>
                <input type="text" id="date">
            </div>
            <div class="content_area">
                <div>
                    <p>누적확진</p>
                    <p id="accDecodeCnt">12,000,000</p>
                </div>
                <div>
                    <p>신규확진</p>
                    <p id="newDecodeCnt">567</p>
                </div>
                <div>
                    <p>격리 중</p>
                    <p id="isolateCnt">678</p>
                </div>
                <div>
                    <p>격리 해제</p>
                    <p id="clearIsolateCnt">789</p>
                </div>
            </div>
            <div class="content_area">
                <div>
                    <p>백신 1차 접종</p>
                    <p id="vaccineFirstCnt">122,322</p>
                </div>
                <div>
                    <p>백신 2차 접종</p>
                    <p id="vaccineSecondCnt">233,333</p>
                </div>
                <div>
                    <p>백신 예약 10부제</p>
                    <p>생년월일 끝자리 <span id="birthEnd">3</span></p>
                </div>
            </div>
            <div class="content_area">
                <div>
                    <p>감염 위험도</p>
                    <p id="covidDanger">
                        <span>안전</span>
                        <span>주의</span>
                        <span>위험</span>
                        <span>매우위험</span>
                    </p>
                </div>
                <div>
                    <p>주의 연령대</p>
                    <p id="dangerAge"><span id="age">30</span>대</p>
                </div>
                <!-- <div>
                    <p>확진률</p>
                    <p id="confirmRate">2.2%</p>
                </div> -->
            </div>
            <div class="content_area chart_content">
                <h1>COVID-19 감염 추이</h1>
                <canvas id="accDecideChart" style="width: 100%; height: 100%;"></canvas>
            </div>
            <div class="content_area chart_content">
                <h1>COVID-19 백신 접종</h1>
                <canvas id="accVaccineChart" style="width: 100%; height: 100%;"></canvas>
            </div>
        </div>
    </div>
</body>
</html>