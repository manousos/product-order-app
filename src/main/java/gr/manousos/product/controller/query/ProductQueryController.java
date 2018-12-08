package gr.manousos.product.controller.query;

import gr.manousos.product.domain.projection.ProductInfoProjection;
import gr.manousos.product.service.query.ProductQueryService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * The query actions for product.
 */
@RestController
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
  @ApiOperation("Retrieve a list of all products")
  ResponseEntity<List<ProductInfoProjection>> getAll() {
    return ResponseEntity.ok(productQueryServiceImpl.findAll());
  }

}
