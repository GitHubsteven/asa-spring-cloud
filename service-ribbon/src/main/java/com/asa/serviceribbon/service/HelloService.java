package com.asa.serviceribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/9/17
 * @Time: 17:19
 * @Description:
 * @version: 1.0.0
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;  //开启负载均衡的功能

    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    }

}