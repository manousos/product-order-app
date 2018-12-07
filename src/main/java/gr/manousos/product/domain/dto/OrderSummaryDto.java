package gr.manousos.product.domain.dto;

import java.time.Instant;
import lombok.Getter;
import lombok.Setter;

/**
 * The order summary data.
 */
@Getter
@Setter
public class OrderSummaryDto {

  /**
   * The order id.
   */
  private Long orderId;
  /**
   * The total price of oder products.
   */
  private Double totalPrice;
  /**
   * The placed order date.
   */
  private Instant datePlaced;
}
