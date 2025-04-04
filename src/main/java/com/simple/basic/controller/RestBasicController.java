package com.simple.basic.controller;

import com.simple.basic.command.SimpleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//@RequestBody = JSON으로 들어오는 데이터 JAVA OBJ로 싹 바꿔줌
@Slf4j
@RestController // 일반 컨트롤러와는 다른 의미, 리턴에 담기는 데이터가 요청한 곳으로 응답함
//@Controller + @Responsebody = @RestController
public class RestBasicController {
    @GetMapping("/hello")
    public String hello() {
        return "<h3>Hello World<h3>";
        // 리턴값 Hello World
    }
    
    //@Responsebody, Json-databind 라이브러리가 이걸 자동으로 해줌
    // 이렇게 던져주면 json 형식으로 던져줌.
    //{"id":1,"name":"홍길동","signInTime":"2025-04-04T12:46:12.9048246"} 출력문
    @GetMapping("/bye")
    public SimpleVO bye() {
        return new SimpleVO(1,"홍길동", LocalDateTime.now());
    }

    // 맵 반환
    @GetMapping("/getMap")
    public Map<String, Object> getMap() {

        Map<String, Object> map = new HashMap<>();
        map.put("name", "유경초이");
        map.put("age", "20");
        map.put("data", new SimpleVO(1,"홍길동", LocalDateTime.now()) );
        return map;
    }

    // 리스트 반환
    @GetMapping("/getList")
    public List<SimpleVO> getList() {
        List<SimpleVO> list = new ArrayList<>();
        list.add(new SimpleVO(1,"홍길동", LocalDateTime.now()));
        list.add(new SimpleVO(2,"홍2길2동", LocalDateTime.now()));
        return list;
    }

    //값을 받는 방법
    //요청의 다양한 방법 get
    //@RequestParam이나, Vo를 통해 받을 수 있음
    @GetMapping("/getData")
    public String getData(@RequestParam("name") String name,
                          @RequestParam("sno") Integer sno,
                          HttpServletRequest request) {
        log.info(request.getRemoteAddr());
        log.info(name);
        log.info(sno.toString());

        return "success";
    }


    @GetMapping("/getData2")
    public String getData2(SimpleVO vo) {
        log.info(vo.toString());
        return "success";
    }

    @GetMapping("/getData3/{name}/{sno}")
    public String getData3(@PathVariable("name") String name,
                           @PathVariable("sno") int sno) {
        log.info(name);
        log.info(String.valueOf(sno));

        return "success";
    }

    // post방식으로 데이터 받기
    // 상대방이 데이터를 보내는 contentType을 저장함(form 타입, json 타입)
    // 받을떄는 map 아니면 vo타입으로 받으면댐

    //보내는형식이 form형식이라는것을 반드시 써줘야함
    @PostMapping("/getForm")
    public String getForm(@RequestParam("name") String name,
                          @RequestParam("sno") int sno) {
        log.info(name);
        log.info(String.valueOf(sno));
        return "success";
    }

    // 보내는 입장이 json타입으로 보내는 경우 -> VO 또는 map타입으로 받기, 리퀘스트파람 불가능
    // @RequestBody 가, json 데이터를 Object에 매핑해줌.
//    @PostMapping("getJson")
//    public String getJson(@RequestBody SimpleVO vo) {
//        log.info(vo.toString());
//        return "success";
//    }

    @PostMapping("getJson")
    public String getJson(@RequestBody Map<String, Object> map) {
        log.info(map.toString());
        return "success";
    }


    /// ///////
    //produces = 서버에서 보내는 타입에 대한 명세 - 아무것도 안적으면 기본 JSON타입
    //consume = 너 보내는 타입은 무조건 이렇게 보내 라는 명세
    @PostMapping(value = "/getResult", produces = "text/plain", consumes = "text/plain")
    public String getResult(@RequestBody String str) {
        log.info(str);

        return "<h3>안녕하세요<h3>";
    }

    //응답 문서 작성하기 -> ResponseEntity <보낼데이터타입>
    @PostMapping("/createEntity")
    public ResponseEntity<SimpleVO> createEntity() {

        SimpleVO vo = new SimpleVO(2,"홍길동",LocalDateTime.now());
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-type", "application/json");
        headers.add("authorization", "JSON WEB TOKEN");
        headers.add("Access-Control-Allow-Origin", "*");
        return new ResponseEntity<>(vo, headers, HttpStatus.OK);
    }

    // 명세에 맞춰 작성후, 부메랑으로 호출
    /*
     요청주소 - /api/v1/getData
     메서드 - get
     클라이언트에서 보내는 데이터 - num, name
     서버에서 응답해주는 데이터 - SimpleVO
     ResponseEntity로 응답
     */

    @GetMapping("/api/v1/getData")
    public ResponseEntity<SimpleVO> getData(SimpleVO vo) {
        log.info(vo.toString());
        return new ResponseEntity<>(vo, HttpStatus.OK);
    }

    /*
    * 요청주소 - /api/v1/getInfo
    * 메서드 - post
    * 클라이언트에서 보내는 데이터 - Json타입 num, name
    * 서버 응답 데이터 - List<SimpleVO>
     ResponseEntity로 응답
    *
    * */

    // 리퀘스트 받는것도 <List<SimpleVO> 처럼 해줘야 여러 값을 받을 수 있음.
    @PostMapping("/api/v1/getInfo")
    public ResponseEntity<List<SimpleVO>> getInfo(@RequestBody List<SimpleVO> voList) {
        log.info(voList.toString());
        return new ResponseEntity<>(voList, HttpStatus.OK);

    }



}
