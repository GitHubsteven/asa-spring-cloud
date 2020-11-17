package com.asa.eurekaclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 这是作为一个独立的服务来说的，但是对于消费者来说可能就是另外一种方式。
 * @Date: Created at 10:30 2018/11/19.
 */
@RestController
@RequestMapping("/service")
public class HiController {
    @RequestMapping(value = "/hi/greeting")
    String greeting(@RequestParam("name") String name) {
        return String.format("hello, %s, welcome to service-hi", name);
    }

}