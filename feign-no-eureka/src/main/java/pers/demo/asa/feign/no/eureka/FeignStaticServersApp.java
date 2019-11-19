package pers.demo.asa.feign.no.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 17:28 2019/11/18.
 */
@SpringBootApplication
//@EnableDiscoveryClient
@EnableFeignClients(basePackages = "pers.demo.asa.feign.no.eureka.feign")
public class FeignStaticServersApp {
    public static void main(String[] args) {
        SpringApplication.run(FeignStaticServersApp.class, args);
    }
}