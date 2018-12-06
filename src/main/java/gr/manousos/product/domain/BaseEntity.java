package gr.manousos.product.domain;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import lombok.Getter;
import lombok.Setter;

/**
 * The base entity.
 *
 * @param <ID> the type of primary key.
 */
@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity<ID> {

  /**
   * The primary key.
   */
  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "id", updatable = false, nullable = false)
  protected ID id;

  /**
   * The row version.
   */
  @Version
  protected Long version;
}
