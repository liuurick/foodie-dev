package com.liubin.foodie.admin;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author liubin
 */
@EnableFeignClients
@EnableDiscoveryClient
@ComponentScan("com.liubin")
@SpringBootApplication
@EnableEncryptableProperties
public class FoodieAdminApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(FoodieAdminApplication.class);

    public static void main(String[] args) throws UnknownHostException {

        Environment env = new SpringApplication(FoodieAdminApplication.class).run(args).getEnvironment();
        String envPort = env.getProperty("server.port");
        String envContext = env.getProperty("server.servlet.context-path");
        String port = envPort == null ? "8806" : envPort;
        String context = envContext == null ? "" : envContext;
        String path = port + "" + context + "/doc.html";
        String druidPath = port + "" + context + "/druid/login.html";
        LOGGER.info("Access URLs:\n----------------------------------------------------------\n\t"
                        + "Local: \t\thttp://127.0.0.1:{}\n\t" + "External: \thttp://127.0.0.1:{}\n\t"
                        + "----------------------------------------------------------", path, druidPath);
    }
}
