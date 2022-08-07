package de.oscharko.microservices.composite.product.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.oscharko.api.core.product.Product;
import de.oscharko.api.core.product.ProductService;
import de.oscharko.api.core.recommendation.Recommendation;
import de.oscharko.api.core.recommendation.RecommendationService;
import de.oscharko.api.core.review.Review;
import de.oscharko.api.core.review.ReviewService;
import de.oscharko.api.exceptions.InvalidInputException;
import de.oscharko.api.exceptions.NotFoundException;
import de.oscharko.util.http.HttpErrorInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

import static org.springframework.http.HttpMethod.GET;

/**
 * IntelliJ IDEA 2022.2 (Ultimate Edition)
 * Created by oscharko on 05.08.22 - 10:57 😎
 * Check out -> www.oscharko.de
 * Microservices-with-Spring-Boot-and-Spring-Cloud
 * Inside the package - de.oscharko.microservices.composite.product.services
 */
@Component
public class ProductCompositeIntegration implements ProductService, RecommendationService, ReviewService {

    private static final Logger LOG = LoggerFactory.getLogger(ProductCompositeIntegration.class);
    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;

    private final String productServiceUrl;
    private final String recommendationServiceUrl;
    private final String reviewServiceUrl;

    /**
     * The constructor stores the injected objects and builds the URLs based on the injected values
     */

    @Autowired
    public ProductCompositeIntegration(
            RestTemplate restTemplate,
            ObjectMapper mapper,
            @Value("${app.product-service.host}") String productServiceHost,
            @Value("${app.product-service.port}") int productServicePort,
            @Value("${app.recommendation-service.host}") String recommendationServiceHost,
            @Value("${app.recommendation-service.port}") int recommendationServicePort,
            @Value("${app.review-service.host}") String reviewServiceHost,
            @Value("${app.review-service.port}") int reviewServicePort) {

        this.restTemplate = restTemplate;
        this.mapper = mapper;

        productServiceUrl = "http://" + productServiceHost + ":" + productServicePort + "/product/";
        recommendationServiceUrl = "http://" + recommendationServiceHost + ":" + recommendationServicePort + "/recommendation?productId=";
        reviewServiceUrl = "http://" + reviewServiceHost + ":" + reviewServicePort + "/review?productId=";
    }

    /**
     * The integration component implements the API methods for the three core services
     * by using RestTemplate to make the actual outgoing calls
     *
     * @param productId ID of the product
     * @return the product information
     */

    public Product getProduct(int productId) {

        try {
            String url = productServiceUrl + productId;
            LOG.debug("Will call getProduct API on URL: {}", url);

            Product product = restTemplate.getForObject(url, Product.class);
            assert product != null;
            LOG.debug("Found a product with id: {}", product.getProductId());

            return product;

        } catch (HttpClientErrorException ex) {

            switch (ex.getStatusCode()) {
                case NOT_FOUND:
                    throw new NotFoundException(getErrorMessage(ex));

                case UNPROCESSABLE_ENTITY:
                    throw new InvalidInputException(getErrorMessage(ex));

                default:
                    LOG.warn("Got an unexpected HTTP error: {}, will rethrow it", ex.getStatusCode());
                    LOG.warn("Error body: {}", ex.getResponseBodyAsString());
                    throw ex;
            }
        }
    }

    /**
     * Returns the error message
     *
     * @param ex error exception thrown by the client application
     * @return error message
     */

    private String getErrorMessage(HttpClientErrorException ex) {
        try {
            return mapper.readValue(ex.getResponseBodyAsString(), HttpErrorInfo.class).getMessage();
        } catch (IOException ioex) {
            return ex.getMessage();
        }
    }

    /**
     * @param productId ID of the product
     * @return the recommendations for the product
     */

    public List<Recommendation> getRecommendations(int productId) {
        String url = recommendationServiceUrl + productId;
        return restTemplate.exchange(url, GET, null, new
                ParameterizedTypeReference<List<Recommendation>>() {
                }).getBody();
    }

    /**
     * @param productId ID of the product
     * @return the review for the product
     */

    public List<Review> getReviews(int productId) {
        String url = reviewServiceUrl + productId;
        return restTemplate.exchange(url, GET, null,
                new ParameterizedTypeReference<List<Review>>() {
                }).getBody();
    }
}
