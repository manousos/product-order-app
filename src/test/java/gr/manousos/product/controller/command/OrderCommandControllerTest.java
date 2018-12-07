package gr.manousos.product.controller.command;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import gr.manousos.product.domain.dto.OrderDto;
import gr.manousos.product.service.command.OrderCommandService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = {TestContext.class})
public class OrderCommandControllerTest {

  private OrderCommandController testClass;
  private OrderCommandService mockCommand;
  private MockMvc mockMvc;
  private ObjectMapper mapper = new ObjectMapper();
  private OrderDto dto = new OrderDto();

  @Before
  public void setUp() {
    mockCommand = mock(OrderCommandService.class);
    testClass = new OrderCommandController(mockCommand);

    mockMvc =
        MockMvcBuilders.standaloneSetup(testClass)
            .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
            .build();
  }

  @Test
  public void placeOrder() throws Exception {
    this.mockMvc
        .perform(MockMvcRequestBuilders.post("/api/order")
            .content(mapper.writeValueAsString(dto))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());

    verify(mockCommand).placeOrder(any());

  }
}
