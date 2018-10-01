package com.landerer.osa.product.contract;

import java.util.List;

public class GetProductsResponse {

    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
