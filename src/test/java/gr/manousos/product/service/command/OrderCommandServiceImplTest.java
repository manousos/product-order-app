package gr.manousos.product.service.command;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import gr.manousos.product.domain.CustomerOrder;
import gr.manousos.product.domain.Product;
import gr.manousos.product.domain.ProductOrder;
import gr.manousos.product.domain.dto.BaseProductDto;
import gr.manousos.product.domain.dto.OrderDto;
import gr.manousos.product.domain.dto.OrderSummaryDto;
import gr.manousos.product.repository.CustomerOrderRepository;
import gr.manousos.product.repository.ProductOrderRepository;
import gr.manousos.product.repository.ProductRepository;
import java.util.Arrays;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

public class OrderCommandServiceImplTest {

  private OrderCommandServiceImpl testClass;

  private CustomerOrderRepository customerOrderRepository;
  private ProductOrderRepository productOrderRepository;
  private ProductRepository productRepository;
  private ModelMapper modelMapper;

  private CustomerOrder inputOrder;
  private OrderDto inputDto;

  @Before
  public void setUp() {
    customerOrderRepository = mock(CustomerOrderRepository.class);
    productOrderRepository = mock(ProductOrderRepository.class);
    productRepository = mock(ProductRepository.class);
    modelMapper = mock(ModelMapper.class);

    testClass = new OrderCommandServiceImpl(
        customerOrderRepository,
        productOrderRepository,
        productRepository,
        modelMapper);

    inputOrder = mock(CustomerOrder.class);
    inputDto = mock(OrderDto.class);
  }

  @Test
  public void testPlaceOrder() {
    OrderSummaryDto expected = new OrderSummaryDto();
    when(modelMapper.map(inputDto, CustomerOrder.class)).thenReturn(inputOrder);
    when(modelMapper.map(any(), eq(OrderSummaryDto.class))).thenReturn(expected);

    assertEquals(expected, testClass.placeOrder(inputDto));
  }

  @Test
  public void testSaveOrderProducts() {
    ProductOrder mockProdOrder = mock(ProductOrder.class);
    BaseProductDto mockProdDto = mock(BaseProductDto.class);

    when(inputDto.getProducts()).thenReturn(Arrays.asList(mockProdDto));
    when(productRepository.findById(mockProdDto.getId()))
        .thenReturn(Optional.of(mock(Product.class)));
    when(productOrderRepository.saveAll(any())).thenReturn(Arrays.asList(mockProdOrder));

    assertEquals(Arrays.asList(mockProdOrder).size(),
        testClass.saveOrderProducts(inputDto, inputOrder).size());
  }

  @Test
  public void testSaveOrder() {
    CustomerOrder expected = new CustomerOrder();
    when(customerOrderRepository.save(inputOrder)).thenReturn(expected);

    assertEquals(expected, testClass.saveOrder(inputOrder));
  }
}
