package de.oscharko.microservices.core.product.services;

import de.oscharko.api.core.product.Product;
import de.oscharko.microservices.core.product.persistence.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * IntelliJ IDEA 2022.2 (Ultimate Edition)
 * --------------------
 * Created by oscharko on 24.08.22 - 11:54 😎
 * Check out -> www.oscharko.de
 * --------------------
 * Microservices-with-Spring-Boot-and-Spring-Cloud
 * Inside the package - de.oscharko.microservices.core.product.services
 * --------------------
 */
@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mappings({
            @Mapping(target = "serviceAddress", ignore = true)
    })
    Product entityToApi(ProductEntity entity);

    @Mappings({
            @Mapping(target = "id", ignore = true), @Mapping(target = "version", ignore = true)
    })
    ProductEntity apiToEntity(Product api);
}
