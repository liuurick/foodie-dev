package com.liubin.foodie.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author liubin
 */
@EnableDiscoveryClient
@SpringBootApplication
public class FoodieGatewayApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(FoodieGatewayApplication.class);

    public static void main(String[] args) throws UnknownHostException {
        Environment env = new SpringApplication(FoodieGatewayApplication.class).run(args).getEnvironment();
        String envPort = env.getProperty("server.port");
        String envContext = env.getProperty("server.servlet.context-path");
        String port = envPort == null ? "8805" : envPort;
        String context = envContext == null ? "" : envContext;
        String path = port + "" + context + "/doc.html";
        String druidPath = port + "" + context + "/druid";
        LOGGER.info("Access URLs:\n----------------------------------------------------------\n\t"
                        + "Local: \t\thttp://127.0.0.1:{}\n\t" + "External: \thttp://{}:{}\n\t"
                        + "----------------------------------------------------------", path,
                InetAddress.getLocalHost().getHostAddress(), path, druidPath);
    }
}