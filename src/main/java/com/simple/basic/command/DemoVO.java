package com.simple.basic.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoVO {
    @Pattern(regexp = "[a-zA-Z0-9]{8,}", message = "아이디는 영문자,숫자 8자 이상입니다")
    private String id;
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*(),.?\":{}|<>]).{8,}$",
            message = "비밀번호는 영문자, 숫자, 특수문자를 조합하여 8글자 이상이어야 합니다.")
    private String pw;

}
