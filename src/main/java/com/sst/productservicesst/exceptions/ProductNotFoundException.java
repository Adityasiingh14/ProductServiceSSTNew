package com.sst.productservicesst.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter

public class ProductNotFoundException extends RuntimeException{
    private Long id;
    public ProductNotFoundException(Long id,String message){
        super(message);
        this.id = id;
    }
    public ProductNotFoundException(String message){
        super(message);
    }
}
