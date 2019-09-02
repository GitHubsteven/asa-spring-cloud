package com.asa.service.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 11:41 2019/9/2.
 */
@RestController
@RequestMapping("/service/order")
public class OrderController {
    @GetMapping("/getOneOrder")
    public String getOneOrder() {
        Random random = new Random();
        return "order:" + random.nextInt();
    }
}