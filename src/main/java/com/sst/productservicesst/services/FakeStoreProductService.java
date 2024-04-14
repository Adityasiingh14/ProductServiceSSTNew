package com.sst.productservicesst.services;

import com.sst.productservicesst.dtos.FakeStoreProductDto;
import com.sst.productservicesst.models.Category;
import com.sst.productservicesst.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService {

    @Override
    public Product getProductById(Long id) {
        //Call the fakeStore API to get the product with given id.
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                        FakeStoreProductDto.class
                );
        //convert FakeStoreProductDto object to Product object.
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
//        product.setCategory(fakeStoreProductDto.getCategory());
        product.setImage_url(fakeStoreProductDto.getImage());
        return product;
    }
}
