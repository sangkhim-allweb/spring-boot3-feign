package com.sangkhim.spring_boot3_feign.config;

import feign.Request;
import feign.slf4j.Slf4jLogger;
import java.time.Duration;
import org.springframework.cloud.openfeign.FeignBuilderCustomizer;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;

public class FeignClientConfig {

  @Bean
  public FeignBuilderCustomizer customizer() {
    return builder ->
        builder
            .options(new Request.Options(Duration.ofMinutes(1), Duration.ofMinutes(1), true))
            .logLevel(feign.Logger.Level.FULL)
            .logger(new Slf4jLogger())
            .retryer(new feign.Retryer.Default(1000, 8000, 3))
            .contract(new SpringMvcContract())
            .options(new Request.Options(Duration.ofMinutes(1), Duration.ofMinutes(1), true))
            .build();
  }
}
