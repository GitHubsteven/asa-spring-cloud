package com.asa.servicefeign.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 14:44 2019/8/8.
 */
@RequestMapping("/demo")
public interface IDemoService {

    @GetMapping("/hello")
    String hello();
}