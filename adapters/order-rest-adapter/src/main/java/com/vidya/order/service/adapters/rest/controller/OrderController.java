package com.vidya.order.service.adapters.rest.controller;

import com.vidya.order.service.ports.OrderGetDrivingPort;
import com.vidya.order.service.ports.model.OrderSummaryModel;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("${spring.application.api.base-path}")
public class OrderController {

  private final OrderGetDrivingPort orderGetDrivingPort;

  @GetMapping("/orders")
  public ResponseEntity<List<OrderSummaryModel>> getAllOrders() {
    return ResponseEntity.ok(orderGetDrivingPort.getOrders());
  }

  @GetMapping("/order/{id}")
  public ResponseEntity<OrderSummaryModel> getOrder(@PathVariable long id) {
    return ResponseEntity.ok(orderGetDrivingPort.getOrderById(id));
  }
}
