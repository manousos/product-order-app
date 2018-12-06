package gr.manousos.product.domain.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * Simple dto for product info.
 */
@Getter
@Setter
public class ProductDto extends BaseProductDto {

  /**
   * The product name.
   */
  @NotBlank
  private String name;
}
