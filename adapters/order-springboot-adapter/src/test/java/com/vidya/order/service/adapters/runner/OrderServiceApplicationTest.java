package com.vidya.order.service.adapters.runner;

import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

class OrderServiceApplicationTest {

  @Test
  @DisplayName("Test OrderServiceApplication main method")
  void test_main() {
    var args = new String[] {"Hi", "Hello"};
    try (MockedStatic<SpringApplication> mocked = mockStatic(SpringApplication.class)) {
      mocked
          .when(() -> SpringApplication.run(OrderServiceApplication.class, args))
          .thenReturn(Mockito.mock(ConfigurableApplicationContext.class));
      OrderServiceApplication.main(args);
      mocked.verify(
          () -> SpringApplication.run(OrderServiceApplication.class, new String[] {"Hi", "Hello"}));
    }
  }
}
