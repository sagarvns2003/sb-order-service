package com.vidya.order.service.usecases;

import com.vidya.common.usecase.UseCase;
import com.vidya.order.service.ports.OrderGetDrivingPort;
import com.vidya.order.service.ports.model.OrderSummaryModel;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UseCase
public class OrderGetUsecase implements OrderGetDrivingPort {

  /*private final OrderGetDrivenPort orderGetDrivenPort;

  public OrderGetUsecase(OrderGetDrivenPort orderGetDrivenPort) {
    this.orderGetDrivenPort = orderGetDrivenPort;
  }*/

  @Override
  public List<OrderSummaryModel> getOrders() {
    return List.of();
  }

  @Override
  public OrderSummaryModel getOrderById(long id) {
    return OrderSummaryModel.builder().build();
  }
}
