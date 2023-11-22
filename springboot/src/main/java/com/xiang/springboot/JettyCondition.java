package com.xiang.springboot;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class JettyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //通过判断项目里面有没有tomcat的特定类来判断有没有引入tomcat依赖
        try {
            //通过类加载器加载tomcat类，如果加载不成功返回false
            context.getClassLoader().loadClass("org.eclipse.jetty.server.Server");
        } catch (ClassNotFoundException e) {
            return false;
        }
        return true;
    }
}
