package gr.manousos.product.domain;

import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 * The product entity.
 */
@Entity
@Getter
@Setter
public class Product extends BaseEntity<Long> {

  /**
   * The product name.
   */
  private String name;
  /**
   * The price(actual) of product.
   */
  private Double productPrice;
}
