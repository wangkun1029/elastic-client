package com.elastic.elastic.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@ComponentScan("com.elastic.elastic.client")
@EnableSwagger2
@SpringBootApplication
public class ElasticClientApplication {

    public static void main(String[] args) {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(ElasticClientApplication.class, args);
    }

}
