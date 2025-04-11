package com.simple.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class SessionController {

    @GetMapping("/login")
    public String login() {
        return "user/login"; // 앞에 슬래시 없이 경로 설정
    }

    @GetMapping("/mypage")
    public String mypage() {

        return "user/mypage"; // 앞에 슬래시 없이 경로 설정
    }

    @GetMapping("/success")
    public String success() {

        return "user/success"; // 앞에 슬래시 없이 경로 설정
    }

    @PostMapping("/loginForm")
    public String loginForm(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            HttpSession session) {
        if (username.equals(password)) {
            session.setAttribute("username", username);
            return "redirect:/user/success"; // 절대 경로로 수정 (슬래시 추가)
        } else {
            return "redirect:/user/login"; // 절대 경로로 수정 (슬래시 추가)
        }
    }
}
