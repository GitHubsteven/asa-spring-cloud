package pers.demo.asa.feign.no.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.demo.asa.feign.no.eureka.service.HiService;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 18:26 2019/11/18.
 */
@RestController
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    private HiService hiService;

    @GetMapping("/hi")
    public String answerHi(@RequestParam("name") String name) {
        String hi = hiService.hi(name);
        String answer = "nice to meet you, this is answer robot!";
        return hi + "\n" + answer;
    }
}