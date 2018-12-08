package gr.manousos.product.controller.command;

import static org.springframework.http.HttpStatus.CREATED;

import gr.manousos.product.domain.Product;
import gr.manousos.product.domain.dto.ProductDto;
import gr.manousos.product.service.command.ProductCommandService;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The command's actions for product.
 */
@RestController
@RequestMapping(value = "/api/product")
class ProductCommandController {

  private final ProductCommandService productCommandService;
  private final ModelMapper modelMapper;

  ProductCommandController(
      ProductCommandService productCommandService, ModelMapper modelMapper) {
    this.productCommandService = productCommandService;
    this.modelMapper = modelMapper;
  }

  /**
   * Create a new product.
   *
   * @param productDto the product data.
   * @return the created product.
   */
  @PostMapping
  @ApiOperation(value = "Create a new product")
  ResponseEntity<ProductDto> save(@RequestBody ProductDto productDto) {
    Product p = productCommandService.save(modelMapper.map(productDto, Product.class));
    return new ResponseEntity<>(modelMapper.map(p, ProductDto.class), CREATED);
  }


  /**
   * Update a product if exists.
   *
   * @param productDto the product data.
   * @return the update product.
   */
  @PutMapping
  @ApiOperation(value = "Update a product if exists")
  ResponseEntity<ProductDto> update(@RequestBody ProductDto productDto) {
    Product p = productCommandService
        .updateById(productDto.getId(), modelMapper.map(productDto, Product.class));
    return ResponseEntity.ok(modelMapper.map(p, ProductDto.class));
  }


}
