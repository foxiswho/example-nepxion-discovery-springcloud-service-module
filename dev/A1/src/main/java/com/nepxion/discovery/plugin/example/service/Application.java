package com.nepxion.discovery.plugin.example.service;

import com.nepxion.discovery.plugin.strategy.service.aop.RestTemplateStrategyInterceptor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import com.nepxion.discovery.plugin.example.service.impl.MyDiscoveryEnabledStrategy;
import com.nepxion.discovery.plugin.example.service.impl.MyRegisterListener;
import com.nepxion.discovery.plugin.example.service.impl.MyDiscoveryListener;
import com.nepxion.discovery.plugin.example.service.impl.MyLoadBalanceListener;
import com.nepxion.discovery.plugin.example.service.impl.MySubscriber;

import java.util.Collections;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Application {
    public static void main(String[] args) {
//        System.setProperty("spring.profiles.active", "a1");

        new SpringApplicationBuilder(Application.class).run(args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateStrategyInterceptor restTemplateStrategyInterceptor) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Collections.singletonList(restTemplateStrategyInterceptor));

        return restTemplate;
    }

    @Bean
    public MyRegisterListener myRegisterListener() {
        return new MyRegisterListener();
    }

    @Bean
    public MyDiscoveryListener myDiscoveryListener() {
        return new MyDiscoveryListener();
    }

    @Bean
    public MyLoadBalanceListener myLoadBalanceListener() {
        return new MyLoadBalanceListener();
    }

    @Bean
    public MySubscriber mySubscriber() {
        return new MySubscriber();
    }

    @Bean
    public MyDiscoveryEnabledStrategy myDiscoveryEnabledStrategy() {
        return new MyDiscoveryEnabledStrategy();
    }
}
