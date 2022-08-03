package de.oscharko.api.core.product;

/**
 * IntelliJ IDEA 2022.2 (Ultimate Edition)
 * Created by oscharko on 03.08.22 - 14:14 😎
 * Check out -> www.oscharko.de
 * Microservices-with-Spring-Boot-and-Spring-Cloud
 * Inside the module - api.core.product
 * Inside the package - de.oscharko.api.composite.core
 */
public class Product {

    private final int productId;
    private final String name;
    private final int weight;
    private final String serviceAddress;

    public Product() {
        productId = 0;
        name = null;
        weight = 0;
        serviceAddress = null;
    }

    public Product(int productId, String name, int weight, String serviceAddress) {
        this.productId = productId;
        this.name = name;
        this.weight = weight;
        this.serviceAddress = serviceAddress;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }
}
