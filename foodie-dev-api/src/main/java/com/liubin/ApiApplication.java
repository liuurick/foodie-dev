package com.liubin;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

/**
 * @author liubin
 */
@SpringBootApplication
public class ApiApplication {
    private static final Logger LOG = LoggerFactory.getLogger(ApiApplication.class);

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(ApiApplication.class);
        Environment env = app.run(args).getEnvironment();
        LOG.info("启动成功！！");
        LOG.info("启动地址为: \thttp://127.0.0.1:{}", env.getProperty("server.port"));
    }

}