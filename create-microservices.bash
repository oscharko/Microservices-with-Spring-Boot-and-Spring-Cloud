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
--package-name=de.oscharko.core.product \
--groupId=de.oscharko.core.product \
--dependencies=actuator,webflux \
--version=0.0.1-SNAPSHOT \
product-service

spring init \
--boot-version=2.7.2 \
--build=gradle \
--java-version=1.8 \
--packaging=jar \
--name=review-service \
--package-name=de.oscharko.core.review \
--groupId=de.oscharko.core.review \
--dependencies=actuator,webflux \
--version=0.0.1-SNAPSHOT \
review-service

spring init \
--boot-version=2.7.2 \
--build=gradle \
--java-version=1.8 \
--packaging=jar \
--name=recommendation-service \
--package-name=de.oscharko.core.recommendation \
--groupId=de.oscharko.core.recommendation \
--dependencies=actuator,webflux \
--version=0.0.1-SNAPSHOT \
recommendation-service

spring init \
--boot-version=2.7.2 \
--build=gradle \
--java-version=1.8 \
--packaging=jar \
--name=product-composite-service \
--package-name=de.oscharko.composite.product \
--groupId=de.oscharko.composite.product \
--dependencies=actuator,webflux \
--version=0.0.1-SNAPSHOT \
product-composite-service

spring init \
--boot-version=2.7.2 \
--build=gradle \
--java-version=1.8 \
--packaging=jar \
--name=api \
--package-name=de.oscharko.api \
--groupId=de.oscharko.api \
--dependencies=webflux \
--version=0.0.1-SNAPSHOT \
api

spring init \
--boot-version=2.7.2 \
--build=gradle \
--java-version=1.8 \
--packaging=jar \
--name=util \
--package-name=de.oscharko.util \
--groupId=de.oscharko.util \
--dependencies=webflux \
--version=0.0.1-SNAPSHOT \
util