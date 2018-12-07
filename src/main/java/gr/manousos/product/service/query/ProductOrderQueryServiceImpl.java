package gr.manousos.product.service.query;

import gr.manousos.product.repository.ProductOrderRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductOrderQueryServiceImpl implements ProductOrderQueryService {

  private final ProductOrderRepository productOrderRepository;

  public ProductOrderQueryServiceImpl(
      ProductOrderRepository productOrderRepository) {
    this.productOrderRepository = productOrderRepository;
  }

  @Override
  public Double calculateTotalPriceOrderByOrderId(Long orderId) {
    return productOrderRepository.getPriceSumbyOrderId(orderId);
  }
}
