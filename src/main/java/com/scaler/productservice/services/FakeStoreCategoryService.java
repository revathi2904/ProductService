package com.scaler.productservice.services;

import com.scaler.productservice.dtos.FakeStoreCategoryDto;
import com.scaler.productservice.dtos.FakeStoreProductDto;
import com.scaler.productservice.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreCategoryService implements CategoryService{

    private RestTemplate restTemplate;

    // Autowird beans tlling spring that - we are not crating ob in this class but getting it from
    // applicatiton context in config folder
    @Autowired
    public FakeStoreCategoryService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public String[] getAllCategories(){
        String[] fakeStoreCategoryDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/categories", String[].class
        );
        return fakeStoreCategoryDto;
    }
}
