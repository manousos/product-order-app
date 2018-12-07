package gr.manousos.product.service.query;

import gr.manousos.product.domain.projection.OrderDetailsProjection;
import gr.manousos.product.repository.CustomerOrderRepository;
import java.time.Instant;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link OrderQueryService}.
 */
@Service
public class OrderQueryServiceImpl implements OrderQueryService {

  private final CustomerOrderRepository customerOrderRepository;

  public OrderQueryServiceImpl(
      CustomerOrderRepository customerOrderRepository) {
    this.customerOrderRepository = customerOrderRepository;
  }

  @Override
  public List<OrderDetailsProjection> getAllOrdersWithinPeriod(Instant dateFrom, Instant dateTo) {
    return customerOrderRepository.getAllByByPlacedDateBetween(dateFrom, dateTo);
  }
}
