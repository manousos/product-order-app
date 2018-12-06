package gr.manousos.product.domain.projection;

/**
 * Projection for product info.
 */
public interface ProductInfoProjection {

  /**
   * Get the product id.
   *
   * @return id.
   */
  Long getId();

  /**
   * Get the product name.
   *
   * @return the name of product.
   */
  String getName();

  /**
   * The the product price.
   *
   * @return the price of product.
   */
  Double getProductPrice();

}
