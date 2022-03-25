package com.liubin.foodie.auth;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;

/**
 * @author liubin
 * @date 2021/12/18
 */
@EnableDiscoveryClient
@SpringBootApplication
public class FoodieAuthApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(FoodieAuthApplication.class);

    public static void main(String[] args) throws UnknownHostException {
        Environment env = new SpringApplication(FoodieAuthApplication.class).run(args).getEnvironment();
        String envPort = env.getProperty("server.port");
        String envContext = env.getProperty("server.servlet.context-path");
        String port = envPort == null ? "8802" : envPort;
        String context = envContext == null ? "" : envContext;
        String path = port + "" + context + "/doc.html";
        String druidPath = port + "" + context + "/druid";
        LOGGER.info("Access URLs:\n----------------------------------------------------------\n\t"
                        + "Local: \t\thttp://127.0.0.1:{}\n\t" + "External: \thttp://{}:{}\n\t"
                        + "----------------------------------------------------------", path,
                InetAddress.getLocalHost().getHostAddress(), path, druidPath);
    }
}