package com.asa.servicefeign.IFeign;

import com.asa.servicefeign.config.FeignServiceConfiguration;
import com.asa.servicefeign.api.IDemoService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 13:26 2019/8/13.
 */
@FeignClient(value = "spring-api-provider", configuration = FeignServiceConfiguration.class)
public interface DemoClient extends IDemoService {
}