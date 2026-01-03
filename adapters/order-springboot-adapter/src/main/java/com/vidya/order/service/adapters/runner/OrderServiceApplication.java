package com.vidya.order.service.adapters.runner;

import com.vidya.common.usecase.UseCase;
import com.vidya.order.service.adapters.rest.OrderRestAdapterConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(
    basePackages = {"com.vidya.order.service.usecases"},
    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = UseCase.class))
@ComponentScan
@Import({OrderRestAdapterConfig.class})
@Slf4j
@SpringBootApplication
public class OrderServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(OrderServiceApplication.class, args);
    log.info("{} Started successfully.", OrderServiceApplication.class.getSimpleName());
  }
}
