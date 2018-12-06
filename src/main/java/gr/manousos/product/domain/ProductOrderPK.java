package gr.manousos.product.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Primary for intermediate table.
 */
@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class ProductOrderPK implements Serializable {

  /**
   * The product id.
   */
  private Long productId;
  /**
   * The order id.
   */
  private Long customerOrderId;
}
