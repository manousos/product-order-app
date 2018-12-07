package gr.manousos.product.service.query;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import gr.manousos.product.domain.projection.ProductInfoProjection;
import gr.manousos.product.repository.ProductRepository;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class ProductQueryServiceImplTest {

  private ProductQueryServiceImpl testClass;
  private ProductRepository mockRepo;

  @Before
  public void setUp() {
    mockRepo = mock(ProductRepository.class);
    testClass = new ProductQueryServiceImpl(mockRepo);
  }

  @Test
  public void testFindAll() {
    ProductInfoProjection mockProd = mock(ProductInfoProjection.class);
    when(mockRepo.getAll()).thenReturn(Arrays.asList(mockProd));

    assertArrayEquals(Arrays.asList(mockProd).toArray(), testClass.findAll().toArray());
  }
}
