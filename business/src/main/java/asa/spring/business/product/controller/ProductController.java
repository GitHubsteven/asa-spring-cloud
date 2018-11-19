package asa.spring.business.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 14:55 2018/11/19.
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @GetMapping("/test")
    public String getTest() {
        return "Test";
    }
}