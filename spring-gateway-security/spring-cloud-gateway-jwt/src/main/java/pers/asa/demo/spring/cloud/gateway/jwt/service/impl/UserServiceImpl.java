package pers.asa.demo.spring.cloud.gateway.jwt.service.impl;

import org.springframework.stereotype.Service;
import pers.asa.demo.spring.cloud.gateway.jwt.bean.UserBean;
import pers.asa.demo.spring.cloud.gateway.jwt.service.IUserService;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/11/27
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Service
public class UserServiceImpl implements IUserService {
    @Override
    public UserBean loadUserByUserName(String userName) {
        return null;
    }
}
