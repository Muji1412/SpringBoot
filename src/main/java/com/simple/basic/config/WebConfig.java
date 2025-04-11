package com.simple.basic.config;

import com.simple.basic.controller.HomeController;
import com.simple.basic.util.interceptor.UserAuthHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Context.xml 파일을 이걸로 대체한다.
@Configuration // 이 클래스를 스프링의 자바설정파일로 쓰겠다는 선언
@PropertySource("classpath:/application-production.properties") // classpath 아래를 가르킴
public class WebConfig implements WebMvcConfigurer {

//    @Value("${server.port}")
//    private String port;
//
//    @Value("${my.example.port}")
//    private String myport;
//
//    @Autowired
//    private ApplicationContext applicationContext;
//
//    @Bean //스프링이  이 메서드를 호출시켜서 반환되는 값을 bean으로 등록
//    public void myTest(){
//
//        System.out.println("myTest 동작함");
//
//        System.out.println("빈의계수:" + applicationContext.getBeanDefinitionCount());
//        HomeController controller = applicationContext.getBean(HomeController.class); //이 타입의 빈 객체를 찾아줘
//        System.out.println("ioc 컨트롤러 안에 컨트롤러 객체 :" + controller);
//
//        System.out.println("프로퍼티 포트값:" + port);
//        System.out.println("프로덕션 프로퍼티 포트값:" + myport);
//
//    }
    @Bean
    public UserAuthHandler userAuthHandler() {
        return new UserAuthHandler();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userAuthHandler())
                .addPathPatterns("/user/*")
                .excludePathPatterns("/user/login","user/loginForm"); // 로그인페이지 제외


                // 필요하면 아래서 한번 더 추가
//        registry.addInterceptor()
//                .addPathPatterns()
    }

//
}
