package com.simple.basic.controller;

import com.simple.basic.command.MemoVO;
import com.simple.basic.memo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/memo")
@RequiredArgsConstructor
public class MemoController {

//    // 멤버변수 주입으로 하는법
//    @Autowired
//    @Qualifier("memoService")
//    private MemoService memoService;

    //생성자 주입

    // 이 아래 코드를 함축적으로 표현해주는게 @RequiredArgsConstructor
    // 이걸 계속 쓰기 싫으니까 롬복에 있는 required 써서 딸깍해서 만듬
//    @Autowired
//    public MemoController(MemoService memoService) {
//        this.memoService = memoService;
//    }

    private final MemoService memoService; // 생성자 주입시에는 무조건 파이널로


    @GetMapping("memoWrite")
    public String memoWrite() {
        return "memo/memoWrite";
    }

    @PostMapping("postMemo")
    public String postMemo(@Valid @ModelAttribute("vo") MemoVO vo, BindingResult result) {

        if (result.hasErrors()) {
            return "memo/memoWrite";
        }

        System.out.println("포스트메모 왔음?");
        System.out.println("vo = " + vo);

        // 포스트메모 확인완료

        int n = memoService.postMemo(vo);
        if (n > 0) {
            System.out.println("게시 성공");
        } else {
            System.out.println("게시 실패");
        }

        return "redirect:/memo/memoList";
    }

    
    // 리다이렉트는 기본적으로 get요청으로 날려줘야함
    @GetMapping("memoList")
    public String memoList(Model model) {
        // 뭐해야하지? 어레이리스트로 값들 받고, 받은거 모델에 넣어주면 되나?

        List<MemoVO> memoList = memoService.getMemoList();

        model.addAttribute("memoList", memoList);

        for (MemoVO memo : memoList) {
            System.out.println(memo);
        }

        return "memo/memoList";
    }
}
