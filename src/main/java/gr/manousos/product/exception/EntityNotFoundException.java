package gr.manousos.product.exception;

/**
 * Unchecked exception when not found a seeking entity from datasource.
 */
public class EntityNotFoundException extends RuntimeException {

  public EntityNotFoundException(String message) {
    super(message);
  }
}
