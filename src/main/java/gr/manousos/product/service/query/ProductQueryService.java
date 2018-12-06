package gr.manousos.product.service.query;

import java.util.List;

/**
 * Query operations for an entity object.
 *
 * @param <E> the type of entity .
 */
public interface ProductQueryService<E> {

  /**
   * Find all entities.
   *
   * @return a list with all entities.
   */
  List<E> findAll();

}
