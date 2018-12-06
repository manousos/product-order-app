package gr.manousos.product.domain;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class ProductOrder {

  @EmbeddedId
  ProductOrderPK productOrderPK;

  @ManyToOne(fetch = LAZY)
  @MapsId("productId")
  private Product product;

  @ManyToOne(fetch = LAZY)
  @MapsId("customerOrderId")
  private CustomerOrder customerOrder;

  /**
   * The price of product when submit the order.
   */
  private Double productPrice;
}
