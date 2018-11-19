package com.asa.eurekaclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 这是作为一个独立的服务来说的，但是对于消费者来说可能就是另外一种方式。
 * @Date: Created at 10:30 2018/11/19.
 */
@Controller
@RequestMapping("/service/hi")
public class HiController {
    @PostMapping(value = "/cn")
    @ResponseBody
    String hiFromCN(@RequestBody Map<String, Object> param) {
        String name = (String) param.get("name");
        return ("你好, " + name);
    }
}