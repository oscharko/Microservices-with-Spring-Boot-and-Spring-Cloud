package de.oscharko.microservices.composite.product.services;

import de.oscharko.api.composite.product.*;
import de.oscharko.api.core.product.Product;
import de.oscharko.api.core.recommendation.Recommendation;
import de.oscharko.api.core.review.Review;
import de.oscharko.api.exceptions.NotFoundException;
import de.oscharko.util.http.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * IntelliJ IDEA 2022.2 (Ultimate Edition)
 * Created by oscharko on 06.08.22 - 09:44 😎
 * Check out -> www.oscharko.de
 * Microservices-with-Spring-Boot-and-Spring-Cloud
 * Inside the package - de.oscharko.microservices.composite.product.services
 */
@RestController
public class ProductCompositeServiceImpl implements ProductCompositeService {

  private final ServiceUtil serviceUtil;
  private final ProductCompositeIntegration integration;

  @Autowired
  public ProductCompositeServiceImpl(
          ServiceUtil serviceUtil, ProductCompositeIntegration integration) {

    this.serviceUtil = serviceUtil;
    this.integration = integration;
  }

  /**
   * Returns a response object of the ProductAggregate type based on the responses from the calls to the integration component
   *
   * @param productId
   * @return
   */
  @Override
  public ProductAggregate getProduct(int productId) {

    Product product = integration.getProduct(productId);
    if (product == null) {
      throw new NotFoundException("No product found for productId: " + productId);
    }

    List<Recommendation> recommendations = integration.getRecommendations(productId);

    List<Review> reviews = integration.getReviews(productId);

    return createProductAggregate(product, recommendations, reviews, serviceUtil.getServiceAddress());
  }

  /**
   * Creates a product aggregate for the given product
   *
   * @param product
   * @param recommendations
   * @param reviews
   * @param serviceAddress
   * @return
   */

  private ProductAggregate createProductAggregate(
          Product product,
          List<Recommendation> recommendations,
          List<Review> reviews,
          String serviceAddress) {

    // 1. Setup product info
    int productId = product.getProductId();
    String name = product.getName();
    int weight = product.getWeight();

    // 2. Copy summary recommendation info, if available
    List<RecommendationSummary> recommendationSummaries =
            (recommendations == null) ? null : recommendations.stream()
                    .map(r -> new RecommendationSummary(r.getRecommendationId(), r.getAuthor(), r.getRate()))
                    .collect(Collectors.toList());

    // 3. Copy summary review info, if available
    List<ReviewSummary> reviewSummaries =
            (reviews == null) ? null : reviews.stream()
                    .map(r -> new ReviewSummary(r.getReviewId(), r.getAuthor(), r.getSubject()))
                    .collect(Collectors.toList());

    // 4. Create info regarding the involved microservices addresses
    String productAddress = product.getServiceAddress();
    String reviewAddress = (reviews != null && reviews.size() > 0) ? reviews.get(0).getServiceAddress() : "";
    String recommendationAddress = (recommendations != null && recommendations.size() > 0) ? recommendations.get(0).getServiceAddress() : "";
    ServiceAddresses serviceAddresses = new ServiceAddresses(serviceAddress, productAddress, reviewAddress, recommendationAddress);

    return new ProductAggregate(productId, name, weight, recommendationSummaries, reviewSummaries, serviceAddresses);
  }
}