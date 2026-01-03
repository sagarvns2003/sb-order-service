package com.vidya.order.service.ports;

import com.vidya.common.port.Port;
import com.vidya.order.service.ports.model.OrderSummaryModel;
import java.util.List;

public interface OrderGetDrivenPort extends Port {
  List<OrderSummaryModel> getOrders();
  OrderSummaryModel getOrderById(long id);
}
