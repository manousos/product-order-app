package gr.manousos.product.service.query;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import gr.manousos.product.repository.ProductOrderRepository;
import org.junit.Before;
import org.junit.Test;

public class ProductOrderQueryServiceImplTest {

  private ProductOrderQueryServiceImpl testClass;

  private ProductOrderRepository mockRepo;

  @Before
  public void setUp() {
    mockRepo = mock(ProductOrderRepository.class);
    testClass = new ProductOrderQueryServiceImpl(mockRepo);
  }

  @Test
  public void calculateTotalPriceOrderByOrderId() {
    when(mockRepo.getPriceSumbyOrderId(1L)).thenReturn(5d);

    assertEquals(new Double(5), testClass.calculateTotalPriceOrderByOrderId(1L));
  }
}
