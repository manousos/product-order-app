package gr.manousos.product.repository;

import gr.manousos.product.domain.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for {@link CustomerOrder} entity.
 */
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {

}
