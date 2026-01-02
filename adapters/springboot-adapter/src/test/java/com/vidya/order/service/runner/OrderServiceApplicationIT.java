package com.vidya.order.service.runner;

import static org.assertj.core.api.Assertions.assertThat;

import com.vidya.common.usecase.UseCase;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest(classes = OrderServiceApplication.class)
class OrderServiceApplicationIT {

  @Autowired private ApplicationContext applicationContext;

  @Test
  @DisplayName("Application context loads successfully")
  void contextLoads() {
    assertThat(applicationContext).isNotNull();
    assertThat(applicationContext.getBean("orderServiceApplication")).isNotNull();
  }

  @Test
  @DisplayName("Verify that UseCase beans are loaded in the application context")
  @Disabled
  void useCaseBeansAreLoaded() {
    var beanNames = applicationContext.getBeanNamesForAnnotation(UseCase.class);
    assertThat(beanNames)
        .isNotEmpty()
        .withFailMessage("Expected at least one @UseCase bean to be loaded");
  }
}
