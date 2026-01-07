package com.vidya.order.service.adapters.rest.controller;

import static org.assertj.core.api.Assertions.assertThat;

import com.vidya.order.service.ports.OrderGetDrivingPort;
import com.vidya.order.service.ports.model.ItemModel;
import com.vidya.order.service.ports.model.OrderSummaryModel;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.test.web.servlet.client.RestTestClient;

class OrderControllerTest {

  private RestTestClient restTestClient;
  private OrderGetDrivingPort orderGetDrivingPort;

  @BeforeEach
  void setUp() {
    orderGetDrivingPort = Mockito.mock(OrderGetDrivingPort.class);
    restTestClient = RestTestClient.bindToController(new OrderController(orderGetDrivingPort)).build();
  }

  @Test
  void getOrderById() throws Exception {

    var item = new ItemModel("Item1", 2, 50.0);
    var order = new OrderSummaryModel(1L, LocalDate.now(), List.of(item));
    Mockito.when(orderGetDrivingPort.getOrderById(1L)).thenReturn(order);

    var orderSummary =
        restTestClient
            .get()
            .uri("/order-service/api/v1/order/1")
            .exchange()
            .expectStatus()
            .isOk()
            .expectBody(OrderSummaryModel.class)
            .returnResult()
            .getResponseBody();

    assertThat(orderSummary.items()).hasSize(1);
    assertThat(orderSummary.items().get(0).name()).isEqualTo("Item1");
    assertThat(orderSummary.items().get(0).qty()).isEqualTo(2);
    assertThat(orderSummary.items().get(0).price()).isEqualTo(50.0);
  }

  @Test
  void getAllOrders() throws Exception {
    var item1 = new ItemModel("Item1", 2, 50.0);
    var item2 = new ItemModel("Item2", 1, 100.0);
    var orders =
        Arrays.asList(
            new OrderSummaryModel(1L, LocalDate.now(), List.of(item1)),
            new OrderSummaryModel(2L, LocalDate.now().minusDays(1L), List.of(item2)));

    Mockito.when(orderGetDrivingPort.getOrders()).thenReturn(orders);

    var allOrders =
        restTestClient
            .get()
            .uri("/order-service/api/v1/orders")
            .exchange()
            .expectStatus()
            .isOk()
            .expectBody(new ParameterizedTypeReference<List<OrderSummaryModel>>() {})
            .returnResult()
            .getResponseBody();

    assertThat(allOrders).hasSize(2);
  }
}
