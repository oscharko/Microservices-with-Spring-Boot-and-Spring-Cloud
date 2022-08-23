package de.oscharko.api.composite.product;

/**
 * IntelliJ IDEA 2022.2 (Ultimate Edition)
 * Created by oscharko on 03.08.22 - 13:44 😎
 * Check out -> www.oscharko.de
 * Microservices-with-Spring-Boot-and-Spring-Cloud
 * Inside the module - api
 * Inside the package - de.oscharko.api.composite.product
 */
public class RecommendationSummary {
    private final int recommendationId;
    private final String author;
    private final int rate;
    private final String content;

    public RecommendationSummary() {
        this.recommendationId = 0;
        this.author = null;
        this.rate = 0;
        this.content = null;
    }

    public RecommendationSummary(int recommendationId, String author, int rate, String content) {
        this.recommendationId = recommendationId;
        this.author = author;
        this.rate = rate;
        this.content = content;
    }

    public int getRecommendationId() {
        return recommendationId;
    }

    public String getAuthor() {
        return author;
    }

    public int getRate() {
        return rate;
    }

    public String getContent() {
        return content;
    }
}
