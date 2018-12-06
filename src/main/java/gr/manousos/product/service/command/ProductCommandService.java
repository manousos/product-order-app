package gr.manousos.product.service.command;

import gr.manousos.product.domain.Product;
import gr.manousos.product.exception.EntityNotFoundException;
import gr.manousos.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@link CommandService} for product entity.
 */
@Service
@Transactional
public class ProductCommandService implements CommandService<Product> {

  private final ProductRepository productRepository;

  public ProductCommandService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public Product save(Product product) {
    return productRepository.save(product);
  }

  @Override
  public Product updateById(Long id, Product product) {
    Product p = productRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Can't find product with id " + id));
    product.setVersion(p.getVersion());

    return productRepository.save(product);
  }

}
