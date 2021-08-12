package com.greenart.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.greenart.service.CoronaInfoService;
import com.greenart.vo.CoronaAgeInfoVO;
import com.greenart.vo.CoronaInfoVO;
import com.greenart.vo.SidoInfoVO;
import com.greenart.vo.VaccineInfoVO;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@RestController
public class CoronaAPIController {
    @Autowired CoronaInfoService service;

    @GetMapping("/api/corona")
    public Map<String, Object> getCoronaInfo(@RequestParam String startDt, @RequestParam String endDt) throws Exception{
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        StringBuilder urlBuilder = new StringBuilder("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=3CID6KRU4kjF4jvHanoFBLwycg6Htt86aVfgEOgBmAecshZIcO5EC9UM9FhVGwAX2Zf%2B%2FrxgsJeUfled1zNS0w%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("startCreateDt","UTF-8") + "=" + URLEncoder.encode(startDt, "UTF-8")); /*검색할 생성일 범위의 시작*/
        urlBuilder.append("&" + URLEncoder.encode("endCreateDt","UTF-8") + "=" + URLEncoder.encode(endDt, "UTF-8")); /*검색할 생성일 범위의 종료*/

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(urlBuilder.toString());

        doc.getDocumentElement().normalize();
        System.out.println(doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("item");
        System.out.println("size : "+nList.getLength());
        if(nList.getLength() <= 0){
            resultMap.put("status", false);
            resultMap.put("message", "데이터가 없습니다.");
            return resultMap;
        }
        for(int i=0; i<nList.getLength(); i++){
            // 순차조회
            Node node =nList.item(i);
            Element elem = (Element) node;

            CoronaInfoVO vo = new CoronaInfoVO();
            vo.setAccExamCnt(Integer.parseInt(getTagValue("accExamCnt", elem))); // 누적 검사 수
            vo.setAccExamCompCnt(Integer.parseInt(getTagValue("accExamCompCnt", elem))); // 누적 검사완료 수
            vo.setCareCnt(Integer.parseInt(getTagValue("careCnt", elem))); // 치료 중
            vo.setClearCnt(Integer.parseInt(getTagValue("clearCnt", elem))); // 격리 해제
            vo.setDeathCnt(Integer.parseInt(getTagValue("deathCnt", elem))); // 사망자 수
            vo.setDecideCnt(Integer.parseInt(getTagValue("decideCnt", elem))); // 확진
            vo.setExamCnt(Integer.parseInt(getTagValue("examCnt", elem))); // 검사진행 수
            vo.setResultNegCnt(Integer.parseInt(getTagValue("resutlNegCnt", elem))); // 음성
            // String to Date
            Date dt = new Date();
            SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dt = dtFormat.parse(getTagValue("createDt", elem));

            vo.setStateTime(dt); // 기준시간

            // System.out.println(vo);
            service.insertCoronaInfo(vo);
        }
        resultMap.put("status", true);
        resultMap.put("message", "데이터가 입력되었습니다.");
        return resultMap;
    }

    @GetMapping("/api/coronaInfo/{date}")
    public Map<String, Object> getCoronaInfo(@PathVariable String date){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        CoronaInfoVO data = null;
        // /api/coronaInfo/today
        if(date.equals("today")){
            data = service.selectTodayCoronaInfo();
        }
        resultMap.put("status", true);
        resultMap.put("data", data);

        return resultMap;
    }

    @GetMapping("/api/sido")
    public Map<String, Object> getSidoInfo(@RequestParam String startDt, @RequestParam String endDt) throws Exception{
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        // 1. 데이터를 가져올 URL을 만드는 과정
        StringBuilder urlBuilder = new StringBuilder("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=3CID6KRU4kjF4jvHanoFBLwycg6Htt86aVfgEOgBmAecshZIcO5EC9UM9FhVGwAX2Zf%2B%2FrxgsJeUfled1zNS0w%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100000", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("startCreateDt","UTF-8") + "=" + URLEncoder.encode(startDt, "UTF-8")); /*검색할 생성일 범위의 시작*/
        urlBuilder.append("&" + URLEncoder.encode("endCreateDt","UTF-8") + "=" + URLEncoder.encode(endDt, "UTF-8")); /*검색할 생성일 범위의 종료*/
        // 2. 데이터 요청 (Reqeust)
        // java.xml.parser
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        // org.w3c.dom
        Document doc = docBuilder.parse(urlBuilder.toString());
        // 3. XML 파싱 시작
        // text -> Node 변환
        doc.getDocumentElement().normalize();
        System.out.println(doc.getDocumentElement().getNodeName());

        NodeList mList = doc.getElementsByTagName("item");
        System.out.println("데이터 수 : "+mList.getLength());
        if(mList.getLength() <= 0){
            resultMap.put("status", false);
            resultMap.put("message", "데이터가 없습니다.");
            return resultMap;
        }
        for(int i=0; i<mList.getLength(); i++){
            // 순차조회
            Node node =mList.item(i);
            Element elem = (Element) node;
            // 문자열로 표현된 날짜를 java.util.Date 클래스 타입으로 변환
            Date cDt = new Date();
            SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            cDt = dtFormat.parse(getTagValue("createDt", elem)); // 문자열로부터 날짜를 유추한다.
            SidoInfoVO vo = new SidoInfoVO();
            vo.setCreateDt(cDt);
            vo.setDeathCnt(Integer.parseInt(getTagValue("deathCnt", elem)));
            vo.setDefCnt(Integer.parseInt(getTagValue("defCnt", elem)));
            vo.setGubun(getTagValue("gubun", elem));
            vo.setIncDec(Integer.parseInt(getTagValue("incDec", elem)));
            vo.setIsolClearCnt(Integer.parseInt(getTagValue("isolClearCnt", elem)));
            vo.setIsolIngCnt(Integer.parseInt(getTagValue("isolIngCnt", elem)));
            vo.setLocalOccCnt(Integer.parseInt(getTagValue("localOccCnt", elem)));
            vo.setOverFlowCnt(Integer.parseInt(getTagValue("overFlowCnt", elem)));

            // System.out.println(vo);
            service.insertCoronaSidoInfo(vo);
        }
        return resultMap;
    }

    @GetMapping("/api/sidoInfo/{date}")
    public Map<String, Object> getSidoInfoDate(@PathVariable String date){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        if(date.equals("today")){
            List<SidoInfoVO> list = service.selectTodaySidoInfo();
            resultMap.put("status", true);
            resultMap.put("data", list);
        } else {
            List<SidoInfoVO> list = service.selectSidoInfo(date);
            resultMap.put("status", true);
            resultMap.put("data", list);
        }
        return resultMap;
    }

    @GetMapping("/api/coronaAge")
    public Map<String, Object> getCoronaAgeInfo(@RequestParam String startDt, @RequestParam String endDt) throws Exception{
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        // 1. 데이터를 가져올 URL을 만드는 과정
        StringBuilder urlBuilder = new StringBuilder("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19GenAgeCaseInfJson"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=3CID6KRU4kjF4jvHanoFBLwycg6Htt86aVfgEOgBmAecshZIcO5EC9UM9FhVGwAX2Zf%2B%2FrxgsJeUfled1zNS0w%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100000", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("startCreateDt","UTF-8") + "=" + URLEncoder.encode(startDt, "UTF-8")); /*검색할 생성일 범위의 시작*/
        urlBuilder.append("&" + URLEncoder.encode("endCreateDt","UTF-8") + "=" + URLEncoder.encode(endDt, "UTF-8")); /*검색할 생성일 범위의 종료*/
        // 2. 데이터 요청 (Reqeust)
        // java.xml.parser
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        // org.w3c.dom
        Document doc = docBuilder.parse(urlBuilder.toString());
        // 3. XML 파싱 시작
        // text -> Node 변환
        doc.getDocumentElement().normalize();
        System.out.println(doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("item");
        System.out.println("데이터 수 : "+nList.getLength());
        if(nList.getLength() <= 0){
            resultMap.put("status", false);
            resultMap.put("message", "데이터가 없습니다.");
            return resultMap;
        }
        for(int i=0; i<nList.getLength(); i++){
            // 순차조회
            Node node =nList.item(i);
            Element elem = (Element) node;

            Date aDt = new Date();
            SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            aDt = dtFormat.parse(getTagValue("createDt", elem)); // 문자열로부터 날짜를 유추한다.
            CoronaAgeInfoVO vo = new CoronaAgeInfoVO();
            vo.setCreateDt(aDt);
            vo.setConfCase(Integer.parseInt(getTagValue("confCase", elem)));
            vo.setConfCaseRate(Double.parseDouble(getTagValue("confCaseRate", elem)));
            vo.setCriticalRate(Double.parseDouble(getTagValue("criticalRate", elem)));
            vo.setDeathRate(Double.parseDouble(getTagValue("deathRate", elem)));
            vo.setDeath(Integer.parseInt(getTagValue("death", elem)));
            String gubun = getTagValue("gubun", elem);
            // if(gubun.equals("남성") || gubun.equals("여성")) continue;
            if(gubun.equals("0-9")) gubun = "0";
            else if(gubun.equals("10-19")) gubun = "10";
            else if(gubun.equals("20-29")) gubun = "20";
            else if(gubun.equals("30-39")) gubun = "30";
            else if(gubun.equals("40-49")) gubun = "40";
            else if(gubun.equals("50-59")) gubun = "50";
            else if(gubun.equals("60-69")) gubun = "60";
            else if(gubun.equals("70-79")) gubun = "70";
            else if(gubun.equals("80 이상")) gubun = "80";
            vo.setGubun(gubun);

            // System.out.println(vo);
            service.insertCoronaAgeInfo(vo);
        }
        return resultMap;
    }

    @GetMapping("/api/corona/{type}/{date}")
    public Map<String, Object> getCoronaAgeGen(@PathVariable String type, @PathVariable String date){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        
        if(date.equals("today") && type.equals("age")){
            return service.selectCoronaTodayAgeInfo();
            // List<CoronaAgeInfoVO> list = service.selectCoronaTodayAgeInfo();
            // resultMap.put("data", list);
        }
        else if(date.equals("today") && type.equals("gen")){
            List<CoronaAgeInfoVO> list = service.selectCoronaTodayGenInfo();
            resultMap.put("data", list);
        }
        else if(type.equals("age")){
            List<CoronaAgeInfoVO> list = service.selectCoronaAgeInfo(date);
            resultMap.put("data", list);
        }
        else if(type.equals("gen")){
            List<CoronaAgeInfoVO> list = service.selectCoronaGenInfo(date);
            resultMap.put("data", list);
        }

        return resultMap;
    }

    public static String getTagValue(String tag, Element elem){
        NodeList nlList = elem.getElementsByTagName(tag).item(0).getChildNodes();
        if(nlList == null) return null;
        Node node = (Node) nlList.item(0);
        if(node == null) return null;
        return node.getNodeValue();
    }

    @GetMapping("/api/corona/vaccine")
    public Map<String, Object> getCoronaVaccine(@RequestParam @Nullable String targetDt) throws Exception{
        Map<String, Object> resultMap = new LinkedHashMap<String ,Object>();

        StringBuilder urlBuilder = new StringBuilder("https://api.odcloud.kr/api/15077756/v1/vaccine-stat"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=3CID6KRU4kjF4jvHanoFBLwycg6Htt86aVfgEOgBmAecshZIcO5EC9UM9FhVGwAX2Zf%2B%2FrxgsJeUfled1zNS0w%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("page","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("perPage","UTF-8") + "=" + URLEncoder.encode("100000", "UTF-8")); /*한 페이지 결과 수*/
        if(targetDt != null){
            targetDt += " 00:00:00";
            urlBuilder.append("&" + URLEncoder.encode("cond[baseDate::EQ]","UTF-8") + "=" + URLEncoder.encode(targetDt, "UTF-8")); /*이 코드 빼면 전체 날짜 범위가 가져와짐*/
        }
        System.out.println(urlBuilder.toString());

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/json");

        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder sb = new StringBuilder();

        String line;
        while((line = rd.readLine()) != null){
            sb.append(line);
        }
        rd.close();
        conn.disconnect();

        System.out.println(sb.toString());

        JSONObject jsonObject = new JSONObject(sb.toString());
        Integer cnt = jsonObject.getInt("currentCount");
        System.out.println("Count : "+cnt);

        JSONArray dataArray = jsonObject.getJSONArray("data");
        for(int i=0; i<dataArray.length(); i++){
            JSONObject obj = dataArray.getJSONObject(i);
            Integer accumulatedFirstCnt = obj.getInt("accumulatedFirstCnt");
            Integer accumulatedSecondCnt = obj.getInt("accumulatedSecondCnt");
            String baseDate = obj.getString("baseDate");
            Integer firstCnt = obj.getInt("firstCnt");
            Integer secondCnt = obj.getInt("secondCnt");
            String sido = obj.getString("sido");
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dt = formatter.parse(baseDate);

            VaccineInfoVO vo = new VaccineInfoVO();
            vo.setAccFirstCnt(accumulatedFirstCnt);
            vo.setAccSecondCnt(accumulatedSecondCnt);
            vo.setRegDt(dt);
            vo.setFistCnt(firstCnt);
            vo.setSecondCnt(secondCnt);
            vo.setSido(sido);

            service.insertCoronaVaccineInfo(vo);
            // System.out.println(accumulatedFirstCnt);
            // System.out.println(accumulatedSecondCnt);
            // System.out.println(baseDate);
            // System.out.println(firstCnt);
            // System.out.println(secondCnt);
            // System.out.println(sido);
            // System.out.println(totalFirstCnt);
            // System.out.println(totalSecondCnt);
        }
        return resultMap;
    }

    @GetMapping("/api/corona/vaccine/{date}")
    public Map<String, Object> getCoronaVaccineInfo(@PathVariable String date){
        Map<String, Object> resultMap = new LinkedHashMap<String ,Object>();

        if(date.equals("today")){
            List<VaccineInfoVO> list = service.selectTodayCoronaVaccineInfo();
            resultMap.put("data", list);
            return resultMap;
        }

        List<VaccineInfoVO> list = service.selectCoronaVaccineInfo(date);
        resultMap.put("data", list);
        return resultMap;
    }
}
