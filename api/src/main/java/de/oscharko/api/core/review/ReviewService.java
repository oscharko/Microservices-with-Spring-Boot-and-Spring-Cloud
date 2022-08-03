package de.oscharko.api.core.review;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * IntelliJ IDEA 2022.2 (Ultimate Edition)
 * Created by oscharko on 03.08.22 - 14:36 😎
 * Check out -> www.oscharko.de
 * Microservices-with-Spring-Boot-and-Spring-Cloud
 * Inside the module - api-core-review
 * Inside the package - de.oscharko.api.core.review
 */
public interface ReviewService {

    /**
     * Sample usage: "curl $HOST:$PORT/review?productId=1".
     *
     * @param productId Id of the product
     * @return the reviews of the product
     */
    @GetMapping(
            value = "/review",
            produces = "application/json")
    List<Review> getReviews(@RequestParam(value = "productId", required = true) int productId);
}
