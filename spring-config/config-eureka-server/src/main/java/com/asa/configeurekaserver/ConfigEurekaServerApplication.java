package com.asa.configeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigEurekaServerApplication.class, args);
    }
}
