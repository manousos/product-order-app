package gr.manousos.product.service.query;

/**
 * Query operations for order entity.
 */
public interface ProductOrderQueryService {

  /**
   * Calculate the total order amount.
   *
   * @return the total order amount.
   */
  Double calculateTotalPriceOrderByOrderId(Long orderId);
}
