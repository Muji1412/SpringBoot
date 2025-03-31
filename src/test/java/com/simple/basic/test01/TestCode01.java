package com.simple.basic.test01;

import com.simple.basic.command.TestBuilderVO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //테스트코드 오더순서에 따라서 할려면 추가
public class TestCode01 {

    //여러 테스트들 중에서, 하나라도 실패하면 서버 빌드에 실패하게 됨.

    @Autowired
    public ApplicationContext applicationContext;
//
//    @Test
//    @Order(2)
//    public void test01() {
//        System.out.println("테스트코드");
//        System.out.println("빈의 개수:" + applicationContext.getBeanDefinitionCount());
//    }
//
//    @Test
//    @Order(1)
//    public void test02() {
//        System.out.println("테스트2번");
//    }

    //빌더패턴

    @Test
    public void test03() {
        TestBuilderVO vo = TestBuilderVO
                .builder()
                .age(20)
                .name("홍길동")
                .build();

        System.out.println(vo.toString());

    }

}
