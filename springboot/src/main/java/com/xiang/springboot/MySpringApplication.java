package com.xiang.springboot;

import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.Map;

public class MySpringApplication {
    /**
     *
     * @param primarySource 配置类
     */
    public static void run(Class<?> primarySource) {
        //创建spring容器
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        //会解析传入类的注解
        applicationContext.register(primarySource);
        applicationContext.refresh();

        //启动tomcat
        //startTomcat(applicationContext);

        //实现启动WebServer
        WebServer webServer = getWebServer(applicationContext);
        webServer.start();
    }

    private static WebServer getWebServer(ApplicationContext applicationContext) {
        Map<String, WebServer> webServers = applicationContext.getBeansOfType(WebServer.class);
        if (webServers.isEmpty()) {
            throw new NullPointerException();
        }
        if (webServers.size() > 1) {
            throw new IllegalStateException();
        }
        //返回唯一的一个
        return webServers.values().stream().findFirst().get();
    }

//    public static void startTomcat(WebApplicationContext applicationContext){
//
//        Tomcat tomcat = new Tomcat();
//
//        Server server = tomcat.getServer();
//        Service service = server.findService("Tomcat");
//
//        Connector connector = new Connector();
//        connector.setPort(8081);
//
//        Engine engine = new StandardEngine();
//        engine.setDefaultHost("localhost");
//
//        Host host = new StandardHost();
//        host.setName("localhost");
//
//        String contextPath = "";
//        Context context = new StandardContext();
//        context.setPath(contextPath);
//        context.addLifecycleListener(new Tomcat.FixContextListener());
//
//        host.addChild(context);
//        engine.addChild(host);
//
//        service.setContainer(engine);
//        service.addConnector(connector);
//
//        //接收到的请求交给DispatcherServlet去处理，而DispatcherServlet会找到请求的方法并执行
//        tomcat.addServlet(contextPath,"dispatcher",new DispatcherServlet(applicationContext));
//        context.addServletMappingDecoded("/*","dispatcher");
//
//        try {
//            tomcat.start();
//        } catch (LifecycleException e) {
//            e.printStackTrace();
//        }
//
//    }
}
