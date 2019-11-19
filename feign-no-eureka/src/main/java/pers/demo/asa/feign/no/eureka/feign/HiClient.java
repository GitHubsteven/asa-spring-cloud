package pers.demo.asa.feign.no.eureka.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 17:40 2019/11/18.
 */
@FeignClient(value = "${api.hi}")
public interface HiClient {
    @RequestMapping("/service/hi")
    String hi(@RequestParam("name") String name);

}