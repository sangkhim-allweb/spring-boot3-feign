package com.sangkhim.spring_boot3_feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringBoot3FeignApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBoot3FeignApplication.class, args);
  }
}
