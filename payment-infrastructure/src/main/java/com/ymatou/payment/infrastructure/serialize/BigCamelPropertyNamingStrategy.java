package com.ymatou.payment.infrastructure.serialize;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;

/**
 * Json属性序列化成大写驼峰格式
 * 
 * @author wangxudong
 *
 */
public class BigCamelPropertyNamingStrategy extends PropertyNamingStrategy {

    @Override
    public String nameForGetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
        return method.getName().substring(3);
    }

    @Override
    public String nameForSetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
        return method.getName().substring(3);
    }
}
