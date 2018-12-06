package gr.manousos.product.controller.query;

import gr.manousos.product.domain.projection.ProductInfoProjection;
import gr.manousos.product.service.query.ProductQueryService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The query actions for product.
 */
@Controller
@RequestMapping(value = "/api/product")
public class ProductQueryController {

  private final ProductQueryService productQueryServiceImpl;

  public ProductQueryController(ProductQueryService productQueryServiceImpl) {
    this.productQueryServiceImpl = productQueryServiceImpl;
  }

  /**
   * Get all products.
   *
   * @return a list of all products.
   */
  @GetMapping("/all")
  ResponseEntity<List<ProductInfoProjection>> getAll() {
    return ResponseEntity.ok(productQueryServiceImpl.findAll());
  }

}
