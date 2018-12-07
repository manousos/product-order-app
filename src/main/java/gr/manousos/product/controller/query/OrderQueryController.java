package gr.manousos.product.controller.query;

import gr.manousos.product.domain.projection.OrderDetailsProjection;
import gr.manousos.product.service.query.OrderQueryService;
import gr.manousos.product.service.query.ProductOrderQueryService;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The query actions for product orders.
 */
@Controller
@RequestMapping(value = "/api/order")
public class OrderQueryController {

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
  ResponseEntity<List<OrderDetailsProjection>> getAllByPeriod(
      @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime dateFrom,
      @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime dateTo) {

    return ResponseEntity.ok(orderQueryServiceImpl.getAllOrdersWithinPeriod(
        ZonedDateTime.of(dateFrom, ZoneId.of("Z")).toInstant(),
        ZonedDateTime.of(dateTo, ZoneId.of("Z")).toInstant()));
  }


  /**
   * Calculate the total order amount, based on the price of the individual products.
   *
   * @return the total order amount.
   */
  @GetMapping("/calc-total-amount/{orderId}")
  ResponseEntity<Double> getAllByPeriod(@PathVariable Long orderId) {
    return ResponseEntity
        .ok(productOrderQueryServiceImpl.calculateTotalPriceOrderByOrderId(orderId));
  }
}
