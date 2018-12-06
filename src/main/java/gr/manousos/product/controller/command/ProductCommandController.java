package gr.manousos.product.controller.command;

import static org.springframework.http.HttpStatus.CREATED;

import gr.manousos.product.domain.Product;
import gr.manousos.product.domain.dto.BaseProductDto;
import gr.manousos.product.domain.dto.ProductDto;
import gr.manousos.product.service.command.ProductCommandService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The command's actions for product.
 */
@Controller
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
  ResponseEntity<BaseProductDto> save(@RequestBody ProductDto productDto) {
    Product p = productCommandService.save(modelMapper.map(productDto, Product.class));
    return new ResponseEntity<>(modelMapper.map(p, ProductDto.class), CREATED);
  }


  /**
   * Update a product if exists. Else create new.
   *
   * @param productDto the product data.
   * @return the update product.
   */
  @PutMapping
  ResponseEntity<BaseProductDto> update(@RequestBody ProductDto productDto) {
    Product p = productCommandService
        .updateById(productDto.getId(), modelMapper.map(productDto, Product.class));
    return ResponseEntity.ok(modelMapper.map(p, ProductDto.class));
  }


}
