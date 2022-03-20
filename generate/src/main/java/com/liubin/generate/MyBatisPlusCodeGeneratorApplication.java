package com.liubin.generate;

import com.fengwenyi.apistarter.EnableApiStarter;
import java.net.UnknownHostException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;


@SpringBootApplication
@EnableApiStarter
public class MyBatisPlusCodeGeneratorApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyBatisPlusCodeGeneratorApplication.class);

    public static void main(String[] args) throws UnknownHostException {

        Environment env = new SpringApplication(MyBatisPlusCodeGeneratorApplication.class).run(args).getEnvironment();
        String envPort = env.getProperty("server.port");
        String envContext = env.getProperty("server.servlet.context-path");
        String port = envPort == null ? "8810" : envPort;
        String context = envContext == null ? "" : envContext;
        String path = port + "" + context;
        LOGGER.info("Access URLs:\n----------------------------------------------------------\n\t"
                + "Local: \t\thttp://127.0.0.1:{}\n\t"
                + "----------------------------------------------------------", path);
    }

}
