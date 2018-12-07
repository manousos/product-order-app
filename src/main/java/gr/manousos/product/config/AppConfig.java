package gr.manousos.product.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Application configuration.
 */
@Configuration
@EnableJpaRepositories(basePackages = "gr.manousos.product.repository")
public class AppConfig {

  /**
   * Bean for model mapper.
   */
  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }


}
