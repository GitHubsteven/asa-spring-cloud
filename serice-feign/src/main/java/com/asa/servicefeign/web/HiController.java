package com.asa.servicefeign.web;

import com.asa.servicefeign.IFeign.DemoClient;
import com.asa.servicefeign.IFeign.SchedualServiceHi;
import com.asa.servicefeign.api.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/9/17
 * @Time: 18:50
 * @Description:
 * @version: 1.0.0
 */
@RestController
public class HiController {
    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    SchedualServiceHi schedualServiceHi;

    @Autowired
    private DemoClient demoClient;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return schedualServiceHi.sayHiFromClientOne(name);
    }

    @GetMapping(value = "/test")
    public String test() {
        return demoClient.hello();
    }
}