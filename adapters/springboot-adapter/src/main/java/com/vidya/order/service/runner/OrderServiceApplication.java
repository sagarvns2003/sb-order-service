package com.vidya.order.service.runner;

import com.vidya.common.usecase.UseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@ComponentScan(
    basePackages = {"com.vidya.common.usecase"},
    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = UseCase.class))
@Slf4j
@SpringBootApplication
public class OrderServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(OrderServiceApplication.class, args);
    log.info("{} Started successfully.", OrderServiceApplication.class.getSimpleName());
  }
}
