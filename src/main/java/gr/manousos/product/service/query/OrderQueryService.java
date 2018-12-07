package gr.manousos.product.service.query;

import gr.manousos.product.domain.projection.OrderDetailsProjection;
import java.time.Instant;
import java.util.List;

/**
 * Query operations for order entity.
 */
public interface OrderQueryService {

  /**
   * Find all orders within a given time period.
   *
   * @param dateFrom the date from (placed orders).
   * @param dateTo the date until (placed orders).
   * @return list of all orders within a given time period.
   */
  List<OrderDetailsProjection> getAllOrdersWithinPeriod(Instant dateFrom, Instant dateTo);
}
