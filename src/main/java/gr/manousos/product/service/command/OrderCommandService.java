package gr.manousos.product.service.command;

import gr.manousos.product.domain.CustomerOrder;
import gr.manousos.product.domain.ProductOrder;
import gr.manousos.product.domain.dto.OrderDto;
import gr.manousos.product.domain.dto.OrderSummaryDto;
import java.util.Set;

public interface OrderCommandService {

  OrderSummaryDto placeOrder(OrderDto orderDto);

  CustomerOrder saveOrder(CustomerOrder customerOrder);

  Set<ProductOrder> saveOrderProducts(OrderDto orderDto, CustomerOrder savedOrder);

}
