package com.vidya.order.service.adapters.rest.controller;

import com.vidya.common.exception.BadRequestException;
import com.vidya.common.exception.ErrorResponse;
import com.vidya.order.service.ports.OrderGetDrivingPort;
import com.vidya.order.service.ports.model.OrderSearchCriteria;
import com.vidya.order.service.ports.model.OrderSummaryModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
// @RequestMapping("${spring.application.api.base-path}")
@RequestMapping("/api/v1/order")
@Tag(name = "Order Service APIs", description = "All order service apis.")
public class OrderController {

  private final OrderGetDrivingPort orderGetDrivingPort;

  @Operation(
      summary = "Get order by search criteria",
      description = "Provide orders detail for given search criteria.")
  @PostMapping(
      value = "/search",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<OrderSummaryModel>> searchOrders(
      @RequestBody(required = true) OrderSearchCriteria searchCriteria) {

    if (true)
      throw new BadRequestException(
          ErrorResponse.builder().errorCode(400).message("bad request").build());

    return ResponseEntity.ok(orderGetDrivingPort.getOrders());
  }

  @Operation(
      summary = "Get order by id",
      description = "Provides order details for given order id.")
  @ApiResponse(
      responseCode = "200",
      content = {
        @Content(
            schema = @Schema(implementation = OrderSummaryModel.class),
            mediaType = MediaType.APPLICATION_JSON_VALUE)
      })
  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<OrderSummaryModel> getOrder(@PathVariable Long id) {
    // Preconditions.checkArgument(Objects.nonNull(id), "Order id can't be null.");
    return ResponseEntity.ok(orderGetDrivingPort.getOrderById(id));
  }
}
