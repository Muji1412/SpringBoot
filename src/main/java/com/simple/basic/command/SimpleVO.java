package com.simple.basic.command;

import lombok.*;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class SimpleVO {
    private int id;
    private String name;
    private LocalDateTime signInTime;
}
