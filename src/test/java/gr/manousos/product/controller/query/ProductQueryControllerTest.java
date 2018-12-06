package gr.manousos.product.controller.query;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import gr.manousos.product.service.query.ProductQueryService;
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
public class ProductQueryControllerTest {

  private ProductQueryController testClass;
  private ProductQueryService mockQueryService;
  /**
   * The mock mvc object.
   */
  private MockMvc mockMvc;

  @Before
  public void setUp() {
    mockQueryService = mock(ProductQueryService.class);
    testClass = new ProductQueryController(mockQueryService);

    mockMvc = MockMvcBuilders.standaloneSetup(testClass).build();
  }

  @Test
  public void getAll() throws Exception {
    this.mockMvc
        .perform(get("/api/product/all"))
        .andExpect(status().isOk());

    verify(mockQueryService).findAll();

  }
}
