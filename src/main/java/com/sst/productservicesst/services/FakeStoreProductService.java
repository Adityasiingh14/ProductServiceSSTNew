package com.sst.productservicesst.services;

import com.sst.productservicesst.dtos.FakeStoreProductDto;
import com.sst.productservicesst.exceptions.ProductNotFoundException;
import com.sst.productservicesst.models.Category;
import com.sst.productservicesst.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service("fakeStoreproductService")
public class FakeStoreProductService implements ProductService {

    @Override
    public Product getProductById(Long id) {
        //Call the fakeStore API to get the product with given id.
//        int x = 1/0;
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                         FakeStoreProductDto.class
                );
        if(fakeStoreProductDto == null){
            throw new ProductNotFoundException(id,"Please pass a valid productID");
        }
        //convert FakeStoreProductDto object to Product object.
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }
    public List<Product> getAllProducts(){
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto[] fakeStoreProductDtos =
                restTemplate.getForObject("https://fakestoreapi.com/products",
                        FakeStoreProductDto[].class);

        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());

        Category category = new Category();
        category.setDescription(fakeStoreProductDto.getDescription());
        product.setCategory(category);
        product.setImage_url(fakeStoreProductDto.getImage());
        return product;
    }
}
