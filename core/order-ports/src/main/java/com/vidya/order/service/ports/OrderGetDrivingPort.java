package com.vidya.order.service.ports;

import com.vidya.order.service.ports.model.OrderSummaryModel;
import java.util.List;

public interface OrderGetDrivingPort {
  List<OrderSummaryModel> getOrders();
  OrderSummaryModel getOrderById(long id);
}
