package pers.asa.demo.spring.cloud.gateway.jwt.controller;

import org.springframework.web.bind.annotation.*;
import pers.asa.demo.spring.cloud.gateway.jwt.bean.DemoRequest;
import pers.asa.demo.spring.cloud.gateway.jwt.bean.UserBean;
import pers.asa.demo.spring.cloud.gateway.jwt.service.IUserService;
import pers.asa.demo.spring.cloud.gateway.jwt.utils.JwtTokenUtil;
import reactor.core.publisher.Mono;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/11/27
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@RestController
@RequestMapping("/service/user")
public class UserController {
    private final JwtTokenUtil jwtTokenUtil;
    private final IUserService iUserService;

    public UserController(JwtTokenUtil jwtTokenUtil,
                          IUserService iUserService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.iUserService = iUserService;
    }

    @PostMapping("/authentication")
    public Mono<String> auth(@RequestBody DemoRequest request) {
        final UserBean userBean = iUserService.loadUserByUserName(request.getUsername());
        final String token = jwtTokenUtil.generateToken(userBean);
        return Mono.just(token);
    }

    @GetMapping("/need-authe")
    public Mono<String> needAuthe() {
        String result = "business";
        return Mono.just(result);
    }
}
