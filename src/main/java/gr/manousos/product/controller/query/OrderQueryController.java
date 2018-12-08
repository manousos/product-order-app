package gr.manousos.product.controller.query;

import gr.manousos.product.domain.projection.OrderDetailsProjection;
import gr.manousos.product.service.query.OrderQueryService;
import gr.manousos.product.service.query.ProductOrderQueryService;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The query actions for product orders.
 */
@RestController
@RequestMapping(value = "/api/order")
public class OrderQueryController {

  private static final String DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm";
  private static final String ZONE_ID = "Z";

  private final OrderQueryService orderQueryServiceImpl;
  private final ProductOrderQueryService productOrderQueryServiceImpl;

  public OrderQueryController(
      OrderQueryService orderQueryServiceImpl,
      ProductOrderQueryService productOrderQueryServiceImpl) {
    this.orderQueryServiceImpl = orderQueryServiceImpl;
    this.productOrderQueryServiceImpl = productOrderQueryServiceImpl;
  }


  /**
   * Get all orders within period.
   *
   * @return a list of all orders by period time.
   */
  @GetMapping("/all/{dateFrom}/{dateTo}")
  @ApiOperation("Retrieving all orders within a given time period")
  ResponseEntity<List<OrderDetailsProjection>> getAllByPeriod(
      @PathVariable @DateTimeFormat(pattern = DATE_TIME_PATTERN) LocalDateTime dateFrom,
      @PathVariable @DateTimeFormat(pattern = DATE_TIME_PATTERN) LocalDateTime dateTo) {

    return ResponseEntity.ok(orderQueryServiceImpl.getAllOrdersWithinPeriod(
        ZonedDateTime.of(dateFrom, ZoneId.of(ZONE_ID)).toInstant(),
        ZonedDateTime.of(dateTo, ZoneId.of(ZONE_ID)).toInstant()));
  }


  /**
   * Calculate the total order amount, based on the price of the individual products.
   *
   * @return the total order amount.
   */
  @GetMapping("/calc-total-amount/{orderId}")
  @ApiOperation("Calculate the total order amount")
  ResponseEntity<Double> getAllByPeriod(@PathVariable Long orderId) {
    return ResponseEntity
        .ok(productOrderQueryServiceImpl.calculateTotalPriceOrderByOrderId(orderId));
  }
}
