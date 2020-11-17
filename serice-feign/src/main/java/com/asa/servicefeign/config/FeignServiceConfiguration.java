package com.asa.servicefeign.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import feign.RequestInterceptor;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 13:27 2019/8/13.
 */
@Configuration
public class FeignServiceConfiguration extends FeignClientsConfiguration {

    @Bean
    public ErrorDecoder errorDecoder() {
        final ObjectMapper objectMapper = new ObjectMapper();
        return (methodKey, response) -> {
            try {
                String body = Util.toString(response.body().asReader());
                Map<String, String> value = objectMapper.readValue(body, objectMapper.getTypeFactory().
                        constructMapType(HashMap.class, String.class, String.class));
                String exceptionName = value.get("exception");
                String message = value.get("message");
                if (StringUtils.isEmpty(exceptionName)) {
                    return new NullPointerException(message);
                } else if (ConstraintViolationException.class.getSimpleName().equals(exceptionName)) {
                    return new IllegalArgumentException(message);
                } else {
                    Class<?> clazz = ClassUtils.forName(exceptionName, Thread.currentThread().getContextClassLoader());
                    if (RuntimeException.class.isAssignableFrom(clazz)) {
                        String code = value.get("error");
                        return (Exception) clazz.getConstructor(String.class, String.class).newInstance(code, message);
                    } else {
                        return Exception.class.isAssignableFrom(clazz) && !StringUtils.isEmpty(message) ?
                                (Exception) clazz.getConstructor(String.class).newInstance(message) :
                                (Exception) clazz.newInstance();
                    }
                }
            } catch (Exception var10) {
                return FeignException.errorStatus(methodKey, response);
            }
        };
    }

    @Bean
    RequestInterceptor requestInterceptor() {
        return new AsaRequestInterceptor();
    }
}