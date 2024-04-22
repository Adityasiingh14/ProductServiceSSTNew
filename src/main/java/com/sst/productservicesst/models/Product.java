package com.sst.productservicesst.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor // constructor for all arguments
@NoArgsConstructor //for default constructor
@Entity
public class Product {
    @Id
    private Long id;
    private String title;
    private Double price;
    private String description;
    @ManyToOne
    private Category category;
    private String image_url;
//    private Rating rating;
}
