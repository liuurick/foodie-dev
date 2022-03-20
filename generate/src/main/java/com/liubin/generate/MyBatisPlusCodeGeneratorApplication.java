package com.liubin.generate;

import com.fengwenyi.apistarter.EnableApiStarter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableApiStarter
@Slf4j
public class MyBatisPlusCodeGeneratorApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(MyBatisPlusCodeGeneratorApplication.class, args);
        } catch (Exception e) {
            log.error(e.getMessage() + "----------------------");
        }
    }

}
