package com.asa.serviceribbon;

import com.asa.serviceribbon.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceRibbonApplicationTests {
    @Autowired
    private HelloService helloService;

    @Test
    public void dynamicMethod() {
        System.out.println(helloService.hiService("blog"));
        System.out.println(helloService.hiService("comments"));
    }

}
