package com.asa.servicefeign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/9/17
 * @Time: 18:48
 * @Description: 为什么feign给我的感觉就是一个转发
 * @version: 1.0.0
 */
@FeignClient(value = "service-hi", fallback = SchedualServiceHiHystric.class)    //通过@ FeignClient（“服务名”），来指定调用哪个服务
public interface SchedualServiceHi {
    @RequestMapping(value = "/hi/greeting", method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}