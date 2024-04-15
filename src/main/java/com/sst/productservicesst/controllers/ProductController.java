package com.sst.productservicesst.controllers;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.sst.productservicesst.dtos.ExceptionDto;
import com.sst.productservicesst.services.FakeStoreProductService;
import com.sst.productservicesst.models.Product;
import com.sst.productservicesst.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;
import java.util.List;

@RestController //this controller is capable to host HTTP API'S.
@RequestMapping("/products") //localhost:8080/products -> product controller
public class ProductController {
    private ProductService productService;
    ProductController(ProductService productService){
        this.productService = productService;
    }

    //localhost:8080/products/10
    @GetMapping("/{id}")
    public ResponseEntity getProductById(@PathVariable("id") Long id) {
//        throw new RuntimeException("Something went wrong");
        ResponseEntity<Product> responseEntity = null;
        Product product = null;
        try{
            product = productService.getProductById(id);
            responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
            System.out.println("Hello");
            return responseEntity;
        }
        catch(RuntimeException exception){
            ExceptionDto dto = new ExceptionDto();
            dto.setMessage("Something went wrong");

            ResponseEntity<ExceptionDto> response = new ResponseEntity<>(dto,HttpStatus.NOT_FOUND);
            return response;
        }
    }

    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
}
