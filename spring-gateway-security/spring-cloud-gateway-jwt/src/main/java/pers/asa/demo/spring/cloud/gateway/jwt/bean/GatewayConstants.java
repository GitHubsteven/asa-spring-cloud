package pers.asa.demo.spring.cloud.gateway.jwt.bean;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/11/27
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class GatewayConstants {
    /**
     * 请求消息头key
     */
    public interface HeaderKey {
        String AUTHORIZATION = "Authorization";
    }

    public static String BEARER_START = "Bearer";
}
