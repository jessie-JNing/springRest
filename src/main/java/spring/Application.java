package spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import spring.exception.CustomExceptionMapper;

@SpringBootApplication
public class Application {

    @Bean
    public CustomExceptionMapper getExceptionMapper() {
        return new CustomExceptionMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}