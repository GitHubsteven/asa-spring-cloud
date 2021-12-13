package com.asa.servicefeign.client;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/4/25 14:55
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/4/25 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Component
public class DynamicFeignClient {
    interface MyCall {
        @GetMapping(value = "/rest-service")
        void callService();
    }
}

