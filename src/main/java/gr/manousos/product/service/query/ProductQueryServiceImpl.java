package gr.manousos.product.service.query;

import gr.manousos.product.domain.projection.ProductInfoProjection;
import gr.manousos.product.repository.ProductRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link ProductQueryService} for product entity.
 */
@Service
public class ProductQueryServiceImpl implements
    ProductQueryService<ProductInfoProjection> {

  private final ProductRepository productRepository;

  public ProductQueryServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public List<ProductInfoProjection> findAll() {
    return productRepository.getAll();
  }
}
