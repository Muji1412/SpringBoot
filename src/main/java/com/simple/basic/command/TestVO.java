package com.simple.basic.command;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor //기본생성자
@AllArgsConstructor // 멤버변수 받는 생성자
//@Getter
//@Setter
//@ToString //toString 메서드 오버라이드
@Data
@Builder
public class TestVO {
    private String id;
    private String pw;
    private String name;
    private int salary;
    private String address;
    private LocalDateTime hireDate;
}
