package com.xiang.springboot;

public class JettyWebServer implements WebServer{
    @Override
    public void start() {
        System.out.println("jetty");
    }
}
