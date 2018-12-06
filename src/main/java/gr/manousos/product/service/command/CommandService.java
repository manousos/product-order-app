package gr.manousos.product.service.command;

/**
 * Command operation's for an entity.
 *
 * @param <E> the type of entity.
 */

public interface CommandService<E> {

  /**
   * Save or update a given object.
   *
   * @param e the entity to persist.
   * @return the saved entity.
   */
  E save(E e);

  /**
   * Find entity by given id and if exist update.
   *
   * @param id the id to search.
   * @param e the entity data to update.
   * @return the updated entity.
   */
  E updateById(Long id, E e);
}
