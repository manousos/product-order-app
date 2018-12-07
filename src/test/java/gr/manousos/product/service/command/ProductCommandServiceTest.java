package gr.manousos.product.service.command;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import gr.manousos.product.domain.Product;
import gr.manousos.product.exception.EntityNotFoundException;
import gr.manousos.product.repository.ProductRepository;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;

public class ProductCommandServiceTest {

  private ProductCommandService testClass;
  private ProductRepository mockRepo;
  private Product inputProduct;

  @Before
  public void setUp() {
    mockRepo = mock(ProductRepository.class);
    testClass = new ProductCommandService(mockRepo);
    inputProduct = mock(Product.class);
  }

  @Test
  public void testSave() {
    Product expected = new Product();
    when(mockRepo.save(inputProduct)).thenReturn(expected);

    assertEquals(expected, testClass.save(inputProduct));
  }

  @Test
  public void testUpdateById() {
    Product expected = new Product();

    when(mockRepo.findById(1L)).thenReturn(Optional.of(inputProduct));
    when(mockRepo.save(inputProduct)).thenReturn(expected);

    assertEquals(expected, testClass.updateById(1L, inputProduct));
  }

  @Test(expected = EntityNotFoundException.class)
  public void testUpdateByIdCaseNotFound() {
    testClass.updateById(1L, inputProduct);
    verify(mockRepo, never()).save(any());
  }
}
