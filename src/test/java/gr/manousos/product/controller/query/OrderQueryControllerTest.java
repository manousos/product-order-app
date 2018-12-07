package gr.manousos.product.controller.query;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import gr.manousos.product.service.query.OrderQueryService;
import gr.manousos.product.service.query.ProductOrderQueryService;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = {TestContext.class})
public class OrderQueryControllerTest {

  private static final String BASE_URL = "/api/order/";

  private OrderQueryController testClass;
  private OrderQueryService mockOrderQueryService;
  private ProductOrderQueryService mockProdQueryService;
  /**
   * The mock mvc object.
   */
  private MockMvc mockMvc;

  @Before
  public void setUp() {
    mockOrderQueryService = mock(OrderQueryService.class);
    mockProdQueryService = mock(ProductOrderQueryService.class);

    testClass = new OrderQueryController(mockOrderQueryService, mockProdQueryService);

    mockMvc = MockMvcBuilders.standaloneSetup(testClass).build();
  }

  @Test
  public void testGetAllOrdersWithinPeriod() throws Exception {
    LocalDateTime from = LocalDateTime.of(2018, 12, 6, 0, 40);
    LocalDateTime to = LocalDateTime.of(2018, 12, 8, 4, 40);
    this.mockMvc
        .perform(get(BASE_URL + "all/" + from + "/" + to))
        .andExpect(status().isOk());

    verify(mockOrderQueryService)
        .getAllOrdersWithinPeriod(ZonedDateTime.of(from, ZoneId.of("Z")).toInstant(),
            ZonedDateTime.of(to, ZoneId.of("Z")).toInstant());

  }


  @Test
  public void testGetAllByPeriod() throws Exception {
    LocalDateTime from = LocalDateTime.of(2018, 12, 6, 0, 40);
    LocalDateTime to = LocalDateTime.of(2018, 12, 8, 4, 40);
    this.mockMvc
        .perform(get(BASE_URL + "/calc-total-amount/1"))
        .andExpect(status().isOk());

    verify(mockProdQueryService).calculateTotalPriceOrderByOrderId(1L);

  }
}
