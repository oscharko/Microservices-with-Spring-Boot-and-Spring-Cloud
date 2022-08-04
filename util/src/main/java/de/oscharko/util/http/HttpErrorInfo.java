package de.oscharko.util.http;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

/**
 * IntelliJ IDEA 2022.2 (Ultimate Edition)
 * Created by oscharko on 04.08.22 - 10:10 😎
 * Check out -> www.oscharko.de
 * Microservices-with-Spring-Boot-and-Spring-Cloud
 * Inside the package - de.oscharko.util.http
 */
public class HttpErrorInfo {

    private final ZonedDateTime timestamp;
    private final String path;
    private final HttpStatus httpStatus;
    private final String message;

    public HttpErrorInfo() {
        timestamp = null;
        httpStatus = null;
        path = "";
        message = "";
    }

    public HttpErrorInfo(ZonedDateTime timestamp, String path, HttpStatus httpStatus, String message) {
        this.timestamp = timestamp;
        this.path = path;
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public String getPath() {
        return path;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }
}
