package com.landerer.osa.product.adaptor;

import com.landerer.osa.product.contract.Product;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.slf4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@Scope("prototype")
public class ProductCatalogAdaptor extends HystrixCommand<List<Product>> {

    private final Logger logger;

    public ProductCatalogAdaptor(Logger logger) {
        super(HystrixCommandGroupKey.Factory.asKey("ProductCatalog"));
        this.logger = logger;
    }

    @Override
    protected List<Product> run() throws Exception {
        return Collections.emptyList();
    }
}
