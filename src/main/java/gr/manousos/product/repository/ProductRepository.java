package gr.manousos.product.repository;

import gr.manousos.product.domain.Product;
import gr.manousos.product.domain.projection.ProductInfoProjection;
import java.util.List;
import javax.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

/**
 * Repository for {@link Product} entity.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

  /**
   * Get all products.
   *
   * @return a list with all products.
   */
  @Query(value = "select p from Product p")
  @QueryHints(value = {@QueryHint(name = "QueryHints.HINT_READONLY", value = "true")})
  List<ProductInfoProjection> getAll();
}
