package com.simple.basic.command;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemoVO {
    private int mno;            // 메모 번호 (자동 증가)
    @Pattern(regexp = "^.{5,}$", message = "메모는 5글자 이상 입력해주세요")
    private String memo;        // 메모 내용 (NOT NULL)
    @Pattern(regexp = "^\\d{3}-\\d{4}-\\d{4}$", message = "올바른 전화번호 형식(예: 010-1234-5678)으로 입력해주세요")
    private String phone;       // 전화번호
    @Pattern(regexp = "^[0-9]{4}$", message = "비밀번호는 숫자 4자리만 입력 가능합니다")
    private String pw;          // 비밀번호 (4자리)
    private char secret;        // 비밀 여부 ('y' 또는 'n')

}
