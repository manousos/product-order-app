package gr.manousos.product.domain.dto;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Simple dto for product info.
 */
@Getter
@Setter
public class BaseProductDto {

  /**
   * The product unique code.
   */
  private Long id;

  /**
   * The product price.
   */
  @NotNull
  private Double price;
}
