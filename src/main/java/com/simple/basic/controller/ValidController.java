package com.simple.basic.controller;

import com.simple.basic.command.DemoVO;
import com.simple.basic.command.ValidVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/valid")
public class ValidController {

    //화면처리
    @GetMapping("/view")
    public String view() {
        return "valid/view";
    }



    @PostMapping("/joinForm")
    public String joinForm(@Valid @ModelAttribute("vo") ValidVO vo, BindingResult result, Model model) {
        //유효성 검사 진행, 실패목록 바인딩리절트에 담아줌

//        if (result.hasErrors()) { //유효성검사 실패시
//            List<FieldError> fieldErrors = result.getFieldErrors();
//            for (FieldError fieldError : fieldErrors) {
//                System.out.println(fieldError.getField());
//                // 실패한 필드명 보여줌
//                System.out.println(fieldError.getDefaultMessage());
//                //실패 디폴트메세지 보여줌
//                model.addAttribute("valid_" + fieldError.getField(), fieldError.getDefaultMessage());
//
//            }
//            return "valid/view";
//        }

        if (result.hasErrors()) {
            return "valid/view";
        }

        System.out.println(vo.toString());

        //처리
        return "redirect:/valid/result";
    }

    //결과화면 화면처리
    @GetMapping("/result")
    public String result() {
        return "valid/result";
    }

    @GetMapping("/quiz01")
    public String quiz01() {
        return "valid/quiz01";
    }

    @PostMapping("/quiz01joinform")
    public String joinform(@Valid @ModelAttribute("vo") DemoVO vo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "valid/quiz01";
        }
        System.out.println(vo.toString());
        return "redirect:/valid/quiz01_result";
    }

    @GetMapping("/quiz01_result")
    public String quiz01_result() {
        return "valid/quiz01_result";
    }




}
