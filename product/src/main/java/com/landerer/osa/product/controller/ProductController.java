package com.landerer.osa.product.controller;

import com.landerer.osa.product.adaptor.ProductCatalogAdaptor;
import com.landerer.osa.product.contract.GetProductsResponse;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public abstract class ProductController {

    private final Logger logger;

    public ProductController(Logger logger) {
        this.logger = logger;
    }


    @GetMapping
    public ResponseEntity<GetProductsResponse> getProducts() {
        this.productCatalogAdaptor().execute();
        return ResponseEntity.ok(new GetProductsResponse());
    }

    @Lookup
    abstract ProductCatalogAdaptor productCatalogAdaptor();
}
