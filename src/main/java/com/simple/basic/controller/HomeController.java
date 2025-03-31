package com.simple.basic.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@Controller
public class HomeController {
    // 레스트 컨트롤러로 보내면 그냥 값 리턴이고, 일반 컨트롤러면 home html로 보내줌
    @GetMapping("/")
    public String home() {

        return "home";

    }
}
