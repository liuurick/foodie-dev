package com.liubin.foodie.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author liubin
 */
@SpringBootApplication
@ComponentScan("com.liubin.*")
public class FoodieAdminApplication {

    public static void main(String[] args) throws UnknownHostException {
        Environment env = new SpringApplication(FoodieAdminApplication.class).run(args).getEnvironment();
        String envPort = env.getProperty("server.port");
        String envContext = env.getProperty("server.servlet.context-path");
        String port = envPort == null ? "8080" : envPort;
        String context = envContext == null ? "" : envContext;
        String path = port + "" + context + "/doc.html";
        String druidPath = port + "" + context + "/druid";
//        log.info("Access URLs:\n----------------------------------------------------------\n\t"
//                        + "Local: \t\thttp://127.0.0.1:{}\n\t" + "External: \thttp://{}:{}\n\t"
//                        + "----------------------------------------------------------", path,
//                InetAddress.getLocalHost().getHostAddress(), path, druidPath);
    }}