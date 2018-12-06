package gr.manousos.product.repository;

import gr.manousos.product.domain.ProductOrder;
import gr.manousos.product.domain.ProductOrderPK;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for {@link ProductOrder} entity.
 */
public interface ProductOrderRepository extends JpaRepository<ProductOrder, ProductOrderPK> {

}
