package gr.manousos.product.service.command;

import static java.time.Instant.now;
import static java.util.stream.Collectors.toSet;

import gr.manousos.product.domain.CustomerOrder;
import gr.manousos.product.domain.Product;
import gr.manousos.product.domain.ProductOrder;
import gr.manousos.product.domain.ProductOrderPK;
import gr.manousos.product.domain.dto.OrderDto;
import gr.manousos.product.domain.dto.OrderSummaryDto;
import gr.manousos.product.repository.CustomerOrderRepository;
import gr.manousos.product.repository.ProductOrderRepository;
import gr.manousos.product.repository.ProductRepository;
import java.util.Set;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderCommandServiceImpl implements OrderCommandService {

  private final CustomerOrderRepository customerOrderRepository;
  private final ProductOrderRepository productOrderRepository;
  private final ProductRepository productRepository;
  private final ModelMapper modelMapper;

  public OrderCommandServiceImpl(
      CustomerOrderRepository customerOrderRepository,
      ProductOrderRepository productOrderRepository,
      ProductRepository productRepository, ModelMapper modelMapper) {
    this.customerOrderRepository = customerOrderRepository;
    this.productOrderRepository = productOrderRepository;
    this.productRepository = productRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public OrderSummaryDto placeOrder(OrderDto orderDto) {
    CustomerOrder customerOrder = modelMapper.map(orderDto, CustomerOrder.class);
    customerOrder.setPlacedDate(now());
    CustomerOrder savedOrder = saveOrder(customerOrder);
    Set<ProductOrder> orderProducts = saveOrderProducts(orderDto, savedOrder);

    OrderSummaryDto summaryDto = modelMapper.map(savedOrder, OrderSummaryDto.class);
    summaryDto.setTotalPrice(
        orderProducts.parallelStream().mapToDouble(ProductOrder::getProductPrice).sum());
    return summaryDto;
  }

  @Override
  public Set<ProductOrder> saveOrderProducts(OrderDto orderDto, CustomerOrder savedOrder) {
    Set<ProductOrder> orderProducts =
        orderDto.getProducts().stream()
            .map(p -> {
                  Product product = productRepository.findById(p.getId()).get();
                  ProductOrderPK key = new ProductOrderPK();
                  key.setCustomerOrderId(savedOrder.getId());
                  key.setProductId(p.getId());
                  ProductOrder productOrder = new ProductOrder();
                  productOrder.setProductPrice(p.getPrice());
                  productOrder.setCustomerOrder(savedOrder);
                  productOrder.setProduct(product);
                  productOrder.setProductOrderPK(key);
                  return productOrder;
                }
            )
            .collect(toSet());
    productOrderRepository.saveAll(orderProducts);

    return orderProducts;
  }

  @Override
  public CustomerOrder saveOrder(CustomerOrder customerOrder) {
    return customerOrderRepository.save(customerOrder);
  }
}
