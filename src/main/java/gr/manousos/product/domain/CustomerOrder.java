package gr.manousos.product.domain;

import static javax.persistence.CascadeType.ALL;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * The order entity data.
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode
public class CustomerOrder extends BaseEntity<Long> {

  @OneToMany(mappedBy = "customerOrder", cascade = ALL, orphanRemoval = true)
  private Set<ProductOrder> productOrders = new HashSet<>();

  /**
   * The placed date of order.
   */
  private Instant placedDate;

  /**
   * The buyer email.
   */
  @Email
  private String email;
}
