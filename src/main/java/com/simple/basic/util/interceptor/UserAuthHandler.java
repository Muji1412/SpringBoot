package com.simple.basic.util.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserAuthHandler implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //리턴 true 연결시 컨트롤러 실행, false가 들어가면 컨트롤러 실행 안함.
        System.out.println("컨트롤러 실행 전 인터셉터 동작");

        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("username");

        if (userId == null) {
            // 인증안될시
            response.sendRedirect("/user/login");
            return false; // 컨트롤러를 실행하지 않음
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("실행 후 인터셉터 동작");
    }
}
