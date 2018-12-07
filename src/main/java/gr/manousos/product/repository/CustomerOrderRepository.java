package gr.manousos.product.repository;

import gr.manousos.product.domain.CustomerOrder;
import gr.manousos.product.domain.projection.OrderDetailsProjection;
import java.time.Instant;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Repository for {@link CustomerOrder} entity.
 */
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {


  /**
   * Find all orders within a given time period.
   *
   * @param dateFrom the date from (placed orders).
   * @param dateTo the date until (placed orders).
   * @return list of all orders within a given time period.
   */
  @Query("select co from CustomerOrder co join fetch co.productOrders po join fetch po.product where co.placedDate between ?1 and ?2")
  List<OrderDetailsProjection> getAllByByPlacedDateBetween(Instant dateFrom, Instant dateTo);
}
