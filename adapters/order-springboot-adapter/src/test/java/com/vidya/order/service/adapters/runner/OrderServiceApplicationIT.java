package com.vidya.order.service.adapters.runner;

import static org.assertj.core.api.Assertions.assertThat;

import com.vidya.common.usecase.UseCase;
import com.vidya.order.service.adapters.rest.controller.OrderController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest(classes = OrderServiceApplication.class)
class OrderServiceApplicationIT {

  @Autowired private ApplicationContext applicationContext;
  @Autowired private OrderController orderController;

  @Test
  @DisplayName("Application context loads successfully")
  void contextLoads() {
    assertThat(applicationContext).isNotNull();
    assertThat(applicationContext.containsBean("orderServiceApplication")).isTrue();
    assertThat(orderController).isNotNull();
  }

  @Test
  @DisplayName("Usecase beans are loaded in the application context.")
  void useCaseBeansAreLoaded() {
    var beanNames = applicationContext.getBeanNamesForAnnotation(UseCase.class);
    assertThat(beanNames)
        .isNotEmpty()
        .allSatisfy(
            beanName -> {
              var bean = applicationContext.getBean(beanName);
              assertThat(bean).isNotNull();
              assertThat(bean.getClass().isAnnotationPresent(UseCase.class)).isTrue();
            });
  }
}
