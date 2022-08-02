#!/usr/bin/env bash

#mkdir Microservices-with-Spring-Boot-and-Spring-Cloud
## shellcheck disable=SC2164
#cd Microservices-with-Spring-Boot-and-Spring-Cloud

spring init \
--boot-version=2.7.2 \
--build=gradle \
--java-version=1.8 \
--packaging=jar \
--name=product-service \
--package-name=se.magnus.microservices.core.product \
--groupId=se.magnus.microservices.core.product \
--dependencies=actuator,webflux \
--version=0.0.1-SNAPSHOT \
product-service

spring init \
--boot-version=2.7.2 \
--build=gradle \
--java-version=1.8 \
--packaging=jar \
--name=review-service \
--package-name=se.magnus.microservices.core.review \
--groupId=se.magnus.microservices.core.review \
--dependencies=actuator,webflux \
--version=0.0.1-SNAPSHOT \
review-service

spring init \
--boot-version=2.7.2 \
--build=gradle \
--java-version=1.8 \
--packaging=jar \
--name=recommendation-service \
--package-name=se.magnus.microservices.core.recommendation \
--groupId=se.magnus.microservices.core.recommendation \
--dependencies=actuator,webflux \
--version=0.0.1-SNAPSHOT \
recommendation-service

spring init \
--boot-version=2.7.2 \
--build=gradle \
--java-version=1.8 \
--packaging=jar \
--name=product-composite-service \
--package-name=se.magnus.microservices.composite.product \
--groupId=se.magnus.microservices.composite.product \
--dependencies=actuator,webflux \
--version=0.0.1-SNAPSHOT \
product-composite-service