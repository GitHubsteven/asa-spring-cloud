package pers.demo.asa.feign.no.eureka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.demo.asa.feign.no.eureka.feign.HiClient;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 17:44 2019/11/18.
 */
@Service
public class HiService {
    @Autowired
    private HiClient hiClient;

    public String hi(String name) {
        return "[feign no eureka:]" + hiClient.hi(name);
    }
}