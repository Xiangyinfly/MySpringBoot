package com.xiang;

import com.xiang.springboot.MySpringApplication;
import com.xiang.springboot.MySpringBootApplication;
import com.xiang.springboot.WebServerAutoConfiguration;
import org.springframework.context.annotation.Import;

@MySpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        MySpringApplication.run(MyApplication.class);
    }
}
