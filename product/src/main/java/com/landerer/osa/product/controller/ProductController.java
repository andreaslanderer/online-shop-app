package com.landerer.osa.product.controller;

import com.landerer.osa.product.contract.GetProductsResponse;
import org.slf4j.Logger;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    public ProductController(Logger logger) {
        this.logger = logger;
    }

    private final Logger logger;

    @GetMapping
    public ResponseEntity<GetProductsResponse> getProducts() {
        this.logger.info("request-id: " + MDC.get("rid"));
        this.logger.info("session-id: " + MDC.get("sid"));
        return ResponseEntity.ok(new GetProductsResponse());
    }
}
