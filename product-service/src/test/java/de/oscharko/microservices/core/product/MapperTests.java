package de.oscharko.microservices.core.product;

import de.oscharko.api.core.product.Product;
import de.oscharko.microservices.core.product.persistence.ProductEntity;
import de.oscharko.microservices.core.product.services.ProductMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

/**
 * IntelliJ IDEA 2022.2 (Ultimate Edition)
 * --------------------
 * Created by oscharko on 24.08.22 - 14:47 😎
 * Check out -> www.oscharko.de
 * --------------------
 * Microservices-with-Spring-Boot-and-Spring-Cloud
 * Inside the package - de.oscharko.microservices.core.product
 * --------------------
 */
public class MapperTests {

    private ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    @Test
    void mapperTests() {

        assertNotNull(mapper);

        Product api = new Product(1, "n", 1, "sa");

        ProductEntity entity = mapper.apiToEntity(api);

        assertEquals(api.getProductId(), entity.getProductId());
        assertEquals(api.getProductId(), entity.getProductId());
        assertEquals(api.getName(), entity.getName());
        assertEquals(api.getWeight(), entity.getWeight());

        Product api2 = mapper.entityToApi(entity);

        assertEquals(api.getProductId(), api2.getProductId());
        assertEquals(api.getProductId(), api2.getProductId());
        assertEquals(api.getName(),      api2.getName());
        assertEquals(api.getWeight(),    api2.getWeight());
        assertNull(api2.getServiceAddress());
    }
}
