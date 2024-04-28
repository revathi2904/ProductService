package com.scaler.productservice.dtos;

import com.scaler.productservice.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private double price;
    private String imageUrl;
    private String description;
    private String category;
}

