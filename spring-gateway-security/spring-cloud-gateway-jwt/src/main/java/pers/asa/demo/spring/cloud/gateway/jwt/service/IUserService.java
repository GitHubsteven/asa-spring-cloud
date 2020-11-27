package pers.asa.demo.spring.cloud.gateway.jwt.service;

import pers.asa.demo.spring.cloud.gateway.jwt.bean.UserBean;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/11/27
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public interface IUserService {
    /**
     * 通过username来查询userModel
     *
     * @param userName 用户名称
     * @return 用户信息
     */
    UserBean loadUserByUserName(String userName);
}
