package gr.manousos.product.domain.projection;

/**
 * The product info data.
 */
public interface ProductOrderInfoProjection {

  /**
   * Get the product name.
   *
   * @return the name of product.
   */
  ProductNameOnly getProduct();

  /**
   * Get the the product price at time of order placed.
   *
   * @return the price of product.
   */
  Double getProductPrice();


  interface ProductNameOnly {

    String getName();
  }
}
