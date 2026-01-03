package com.vidya.order.service.ports.model;

import lombok.Builder;

@Builder
public record ItemModel(String name, int qty, double price) {}
