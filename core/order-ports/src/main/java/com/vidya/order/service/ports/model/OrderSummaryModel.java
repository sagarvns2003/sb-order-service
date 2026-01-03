package com.vidya.order.service.ports.model;

import java.time.LocalDate;
import java.util.List;
import lombok.Builder;

@Builder
public record OrderSummaryModel(long id, LocalDate orderdate, List<ItemModel> items) {}
