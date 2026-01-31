package com.vidya.order.service.adapters.rest;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Vidya Sagar Gupta
 * @since v1.0.0
 */
@Configuration
@ComponentScan
public class OrderRestAdapterConfig {

  @Bean
  public OpenAPI customOpenApi() {
    return new OpenAPI()
        .info(
            new Info()
                .title("Order Service API Definition")
                .summary("This is summary.")
                .description("These APIs exposes endpoints to manage orders.")
                .version("1.0.0")
                .license(new License().name("No Licence Required"))
                .contact(
                    new Contact()
                        .name("Vidya Sagar Gupta")
                        .email("v3sagar@gmail.com")
                        .url("https://www.linkedin.com/in/vidyasagar-gupta/")));
  }
}
