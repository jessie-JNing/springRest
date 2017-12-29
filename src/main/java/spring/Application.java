package spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerExceptionResolver;
import spring.exception.CustomHandlerExceptionResolver;

@SpringBootApplication
public class Application {


    @Bean
    HandlerExceptionResolver customExceptionResolver () {
        return new CustomHandlerExceptionResolver();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}