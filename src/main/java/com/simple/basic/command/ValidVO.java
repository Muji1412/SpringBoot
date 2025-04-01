package com.simple.basic.command;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


//@Notnull - null 제외 -> wrapper 씀, 인티저, 롱 등등
//@NotEmpty - null 제외, 공백허용x - Array, Map, String 가능
//@NotBlank - null 제외, 공백허용x, 화이트스페이스 x String 적용

//@Pattern - 정규표현식으로
//@Email - 이메일검사
//@Size - 크기검사
//등등등..
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidVO {

    @NotBlank(message = "이름 입력은 필수입니다")
    private String name;
    @NotNull(message = "급여 입력은 필수입니다")
    private Integer salary;
    @Pattern(regexp = "[0-9]{3}-[0-9]{4}-[0-9]{4}", message = "전화번호는 010-0000-0000 형식입니다.")
    private String phone;
    @NotBlank
    @Email(message = "이메일 형식을 지켜주세요.")
    private String email;
}
