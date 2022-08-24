package de.oscharko.microservices.core.product.persistence;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

/**
 * IntelliJ IDEA 2022.2 (Ultimate Edition)
 * --------------------
 * Created by oscharko on 24.08.22 - 11:48 😎
 * Check out -> www.oscharko.de
 * --------------------
 * Microservices-with-Spring-Boot-and-Spring-Cloud
 * Inside the package - de.oscharko.microservices.core.product.persistence
 * --------------------
 */
public interface ProductRepository extends PagingAndSortingRepository<ProductEntity, String> {
    Optional<ProductEntity> findByProductId(int productId);
}
