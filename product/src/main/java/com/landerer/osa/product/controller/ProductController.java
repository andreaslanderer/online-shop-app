package com.landerer.osa.product.controller;

import com.landerer.osa.product.contract.GetProductsResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public ResponseEntity<GetProductsResponse> getProducts() {
        return ResponseEntity.ok(new GetProductsResponse());
    }
}
