package com.simple.basic.controller;

import com.simple.basic.command.SimpleVO;
import com.simple.basic.command.TestBuilderVO;
import com.simple.basic.command.TestVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Controller
public class ThymeleafController {

    @GetMapping("/ex01")
    public String ex01() {
        return "views/ex01";
    }

    @GetMapping("/ex02")
    public String ex02(Model model) {
        ArrayList<TestVO> list = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            TestVO vo= TestVO
                    .builder()
                    .id("aaa" + i)
                    .name("홍길동" + i)
                    .address("서울시" + i)
                    .hireDate(LocalDateTime.now())
                    .salary(3000 + i)
                    .build();
            list.add(vo);
        }
        model.addAttribute("list", list);
        return "views/ex02";
    }

    @GetMapping("/ex03")
    public String ex03(Model model) {
        ArrayList<TestVO> list = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            TestVO vo= TestVO
                    .builder()
                    .id("aaa" + i)
                    .name("홍길동" + i)
                    .address("서울시" + i)
                    .hireDate(LocalDateTime.now())
                    .salary(3000 + i)
                    .build();
            list.add(vo);
        }
        model.addAttribute("list", list);
        return "views/ex03";
    }

    @GetMapping("/result")
    public String result() {
        return "views/result";
    }
    @GetMapping("/result2/{address}/{value}")
    public String result2(@PathVariable("address") String address, @PathVariable("value") String value) {
        System.out.println(address + ", " + value);
        return "views/result2";
    }

    @GetMapping("/ex04")
    public String ex04(Model model) {

        TestVO vo = new TestVO();
        vo.setId("abc123");
        vo.setId("경기도");
        vo.setId("홍길동");
        vo.setHireDate(LocalDateTime.now());

        model.addAttribute("vo", vo);

        return "views/ex04";
    }

    @GetMapping("/ex05")
    public String ex05() {

        return "views/ex05";
    }

    @GetMapping("/ex06")
    public String ex06() {

        return "views/ex06";
    }

    @GetMapping("/quiz01")
    public String quiz01() {

        return "views/quiz01";
    }


    //ModelAttribute 해서 @ModelAttribute("SimpleVO") SimpleVO vo해도됨
    @GetMapping("quiz01_result")
    public String quiz01_result(@RequestParam int id,
                                @RequestParam String name,
                                Model model) {
        System.out.println(id + ", " + name + ", " + model);
        SimpleVO vo = SimpleVO
                        .builder()
                        .id(id)
                        .name(name)
                        .signInTime(LocalDateTime.now())
                        .build();

        model.addAttribute("vo", vo);
        System.out.println(vo);
        return "views/quiz01_result";
    }

}
