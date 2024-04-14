package com.sst.productservicesst.controllers;

import com.sst.productservicesst.services.FakeStoreProductService;
import com.sst.productservicesst.models.Product;
import com.sst.productservicesst.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //this controller is capable to host HTTP API'S.
@RequestMapping("/products") //localhost:8080/products -> product controller
public class ProductController {
    private ProductService productService;
    ProductController(ProductService productService){
        this.productService = productService;
    }

    //localhost:8080/products/10
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }
}
