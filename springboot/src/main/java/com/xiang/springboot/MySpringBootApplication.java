package com.xiang.springboot;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
//如果没有指定扫描的包路径，默认扫描被解析的类所在的包
@ComponentScan
@Import(WebServerAutoConfiguration.class)
public @interface MySpringBootApplication {
}
