package com.asa.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

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

    private final LoadBalancerClient loadBalancerClient;

    private final RestTemplate restTemplate;  //开启负载均衡的功能

    private final Map<String, String> bizType2ServiceId = new HashMap<>(2);

    public HelloService(RestTemplate restTemplate, LoadBalancerClient loadBalancerClient) {
        this.restTemplate = restTemplate;
        bizType2ServiceId.put("blog", "VWE-BLOGS");
        bizType2ServiceId.put("comments", "VWE-COMMENTS");
        this.loadBalancerClient = loadBalancerClient;
    }

    @HystrixCommand(fallbackMethod = "hiError")     //熔断反馈方法
    public String hiService(String name) {

        final String serviceId = bizType2ServiceId.get(name);
        final ServiceInstance instance = loadBalancerClient.choose(serviceId);
        String url = String.format("http://%s:%s/%s/get-by-name/", instance.getHost(), instance.getPort(), name);
        return restTemplate.getForObject(url + name, String.class);
    }

    /**
     * 熔断处理机制
     *
     * @param name 名称
     * @return
     */
    public String hiError(String name) {
        return "hi," + name + ",sorry,error!";
    }
}