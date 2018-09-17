package com.asa.servicefeign.IFeign;

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
 * @Description:
 * @version: 1.0.0
 */
@FeignClient(value = "service-hi", fallback = SchedualServiceHiHystric.class)    //通过@ FeignClient（“服务名”），来指定调用哪个服务
public interface SchedualServiceHi {
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}