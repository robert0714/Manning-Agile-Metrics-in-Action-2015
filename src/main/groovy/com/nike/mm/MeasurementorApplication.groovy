package com.nike.mm

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchAutoConfiguration
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration
import org.springframework.boot.web.support.SpringBootServletInitializer
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.context.annotation.ComponentScan
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.annotation.EnableScheduling

@SuppressWarnings("all")
@EnableAutoConfiguration(exclude = [ElasticsearchDataAutoConfiguration, ElasticsearchAutoConfiguration])
@ComponentScan
@EnableAsync
@EnableScheduling
@SpringBootApplication
@EnableEurekaClient
class MeasurementorApplication extends SpringBootServletInitializer {

    static void main(String[] args) {
        SpringApplication.run MeasurementorApplication, args
    }
}
