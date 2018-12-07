package gr.manousos.product.domain.dto;

import java.util.List;
import javax.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {

  @Email
  private String email;

  List<BaseProductDto> products;
}
