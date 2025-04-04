package com.simple.basic.command;

import lombok.*;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
@Data
public class SimpleVO {
    private int sno;
    private String name;
    private LocalDateTime signInTime;
}
