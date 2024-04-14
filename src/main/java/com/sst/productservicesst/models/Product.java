package com.sst.productservicesst.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor // constructor for all arguments
@NoArgsConstructor //for default constructor
public class Product {
    private Long id;
    private String title;
    private Double price;
    private String description;
    private Category category;
    private String image_url;
//    private Rating rating;
}
