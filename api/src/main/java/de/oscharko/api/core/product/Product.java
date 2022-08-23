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

    private int productId;
    private String name;
    private int weight;
    private String serviceAddress;

    public Product() {
        productId = 0;
        name = "";
        weight = 0;
        serviceAddress = "";
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

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }
}
