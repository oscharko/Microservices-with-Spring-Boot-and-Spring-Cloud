package de.oscharko.microservices.composite.product.services;

import de.oscharko.api.core.product.ProductService;
import de.oscharko.api.core.recommendation.RecommendationService;
import de.oscharko.api.core.review.ReviewService;
import org.springframework.stereotype.Component;

/**
 * IntelliJ IDEA 2022.2 (Ultimate Edition)
 * Created by oscharko on 05.08.22 - 10:57 😎
 * Check out -> www.oscharko.de
 * Microservices-with-Spring-Boot-and-Spring-Cloud
 * Inside the package - de.oscharko.microservices.composite.product.services
 */
@Component
public class ProductCompositeIntegration implements ProductService, RecommendationService, ReviewService {
}
