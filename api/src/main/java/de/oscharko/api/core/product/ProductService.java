package de.oscharko.api.core.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * IntelliJ IDEA 2022.2 (Ultimate Edition)
 * Created by oscharko on 03.08.22 - 14:14 😎
 * Check out -> www.oscharko.de
 * Microservices-with-Spring-Boot-and-Spring-Cloud
 * Inside the module - api.core.product
 * Inside the package - de.oscharko.api.composite.core
 */
public interface ProductService {

    /**
     * Sample usage: "curl $HOST:$PORT/product/1".
     *
     * @param productId ID of the product
     * @return the product, if found, else null
     */
    @GetMapping(
            value = "/product/{productId}",
            produces = "application/json")
    Product getProduct(@PathVariable int productId);
}
