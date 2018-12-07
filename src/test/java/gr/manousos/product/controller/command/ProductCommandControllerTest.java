package gr.manousos.product.controller.command;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import gr.manousos.product.domain.Product;
import gr.manousos.product.domain.dto.BaseProductDto;
import gr.manousos.product.domain.dto.ProductDto;
import gr.manousos.product.service.command.ProductCommandService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
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
public class ProductCommandControllerTest {

  private static final String URI = "/api/product";

  private ProductCommandService mockCommandService;
  private ModelMapper mockMapper;
  private ProductCommandController testClass;
  /**
   * The mock object
   */
  private MockMvc mockMvc;

  private BaseProductDto dto = new BaseProductDto();
  private ObjectMapper mapper = new ObjectMapper();

  @Before
  public void setUp() {
    mockCommandService = mock(ProductCommandService.class);
    mockMapper = mock(ModelMapper.class);

    testClass = new ProductCommandController(mockCommandService, mockMapper);
    mockMvc =
        MockMvcBuilders.standaloneSetup(testClass)
            .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
            .build();

    dto.setPrice(1d);
  }

  @Test
  public void testSave() throws Exception {

    this.mockMvc
        .perform(MockMvcRequestBuilders.post(URI)
            .content(mapper.writeValueAsString(dto))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());

    verify(mockMapper).map(any(ProductDto.class), eq(Product.class));
    verify(mockCommandService).save(any());
    verify(mockMapper).map(any(), eq(ProductDto.class));

  }

  @Test
  public void testUpdate() throws Exception {
    this.mockMvc
        .perform(MockMvcRequestBuilders.put(URI)
            .content(mapper.writeValueAsString(dto))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
    verify(mockCommandService).updateById(any(), any());
    verify(mockMapper).map(any(), eq(ProductDto.class));
  }
}
