package com.asa.spring.cloud.gateway.advice;

import com.asa.spring.cloud.gateway.bean.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @date: Created at 15:06 2019/8/9.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger =
            LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseData defaultErrorHandler(HttpServletRequest req,
                                            Exception e) throws Exception {
        logger.error("", e);
        ResponseData resp = new ResponseData();
        resp.setMessage(e.getMessage());
        resp.setCode(e instanceof Exception ? 404 : 500);
        resp.setData(null);
        resp.setStatus(false);
        return resp;
    }
}