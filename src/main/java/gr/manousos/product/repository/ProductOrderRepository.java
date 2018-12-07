package gr.manousos.product.repository;

import gr.manousos.product.domain.ProductOrder;
import gr.manousos.product.domain.ProductOrderPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Repository for {@link ProductOrder} entity.
 */
public interface ProductOrderRepository extends JpaRepository<ProductOrder, ProductOrderPK> {

  @Query("select sum (po.productPrice) from ProductOrder po where po.productOrderPK.customerOrderId= :orderId ")
  Double getPriceSumbyOrderId(Long orderId);
}
