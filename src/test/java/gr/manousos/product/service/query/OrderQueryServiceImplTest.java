package gr.manousos.product.service.query;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import gr.manousos.product.domain.projection.OrderDetailsProjection;
import gr.manousos.product.repository.CustomerOrderRepository;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class OrderQueryServiceImplTest {

  private OrderQueryServiceImpl testClass;

  private CustomerOrderRepository mockRepo;

  @Before
  public void setUp() {
    mockRepo = mock(CustomerOrderRepository.class);

    testClass = new OrderQueryServiceImpl(mockRepo);
  }

  @Test
  public void tesGetAllOrdersWithinPeriod() {
    List<OrderDetailsProjection> expected = Arrays.asList(mock(OrderDetailsProjection.class));
    Instant from = Instant.now().minus(1, ChronoUnit.DAYS);
    Instant to = Instant.now().plus(1, ChronoUnit.DAYS);
    when(mockRepo.getAllByByPlacedDateBetween(from, to)).thenReturn(expected);

    assertEquals(expected, testClass.getAllOrdersWithinPeriod(from, to));
  }
}
