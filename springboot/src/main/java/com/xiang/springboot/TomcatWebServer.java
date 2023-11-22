package com.xiang.springboot;

public class TomcatWebServer implements WebServer{

    @Override
    public void start() {
        System.out.println("tomcat");
    }
}
