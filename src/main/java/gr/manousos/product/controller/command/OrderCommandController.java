package gr.manousos.product.controller.command;

import static org.springframework.http.HttpStatus.CREATED;

import gr.manousos.product.domain.dto.OrderDto;
import gr.manousos.product.domain.dto.OrderSummaryDto;
import gr.manousos.product.service.command.OrderCommandService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The command's actions for product orders.
 */
@Controller
@RequestMapping(value = "/api/order")
public class OrderCommandController {

  private final OrderCommandService orderCommandServiceImpl;

  public OrderCommandController(OrderCommandService orderCommandServiceImpl) {
    this.orderCommandServiceImpl = orderCommandServiceImpl;
  }

  /**
   * Place an order.
   *
   * @param orderDto the order data.
   * @return the created customer order summary.
   */
  @PostMapping
  ResponseEntity<OrderSummaryDto> placeOrder(@RequestBody OrderDto orderDto) {
    return new ResponseEntity<>(orderCommandServiceImpl.placeOrder(orderDto), CREATED);
  }
}
