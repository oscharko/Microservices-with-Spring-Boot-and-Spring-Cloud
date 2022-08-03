package de.oscharko.api.core.review;

/**
 * IntelliJ IDEA 2022.2 (Ultimate Edition)
 * Created by oscharko on 03.08.22 - 14:36 😎
 * Check out -> www.oscharko.de
 * Microservices-with-Spring-Boot-and-Spring-Cloud
 * Inside the module - api-core-review
 * Inside the package - de.oscharko.api.core.review
 */
public class Review {
    private final int productId;
    private final int reviewId;
    private final String author;
    private final String subject;
    private final String content;
    private final String serviceAddress;

    public Review() {
        productId = 0;
        reviewId = 0;
        author = "";
        subject = "";
        content = "";
        serviceAddress = "";
    }

    public Review(int productId, int reviewId, String author, String subject, String content, String serviceAddress) {
        this.productId = productId;
        this.reviewId = reviewId;
        this.author = author;
        this.subject = subject;
        this.content = content;
        this.serviceAddress = serviceAddress;
    }

    public int getProductId() {
        return productId;
    }

    public int getReviewId() {
        return reviewId;
    }

    public String getAuthor() {
        return author;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }
}
