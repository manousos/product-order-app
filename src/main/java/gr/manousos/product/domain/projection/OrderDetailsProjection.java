package gr.manousos.product.domain.projection;

import java.time.Instant;
import java.util.List;

/**
 * Order details data.
 */
public interface OrderDetailsProjection {

  /**
   * Get the order id.
   *
   * @return the order id.
   */
  Long getId();

  /**
   * Get the date time of order placed.
   *
   * @return the placed order date time.
   */
  Instant getPlacedDate();

  /**
   * Get the email of customer.
   *
   * @return the email.
   */
  String getEmail();

  /**
   * Get all products info for order.
   *
   * @return the list of order products.
   */
  List<ProductOrderInfoProjection> getProductOrders();
}
