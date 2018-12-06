package gr.manousos.product.domain;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

/**
 * The product entity.
 */
@Entity
@Getter
@Setter
public class Product extends BaseEntity<Long> {

  /**
   * The product name.
   */
  private String name;
  /**
   * The price(actual) of product.
   */
  private Double productPrice;
}
