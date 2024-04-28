package com.scaler.productservice.services;

import com.scaler.productservice.dtos.FakeStoreProductDto;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
   private RestTemplate restTemplate;

   // Autowird beans tlling spring that - we are not crating ob in this class but getting it from
    // applicatiton context in config folder
   @Autowired
   public FakeStoreProductService(RestTemplate restTemplate){
       this.restTemplate = restTemplate;
   }

   private Product convertFakeStoreProductToProduct(FakeStoreProductDto fakeStoreProductDto){
       Product p = new Product();
       p.setTitle(fakeStoreProductDto.getTitle());
       p.setDescription(fakeStoreProductDto.getDescription());
       p.setPrice(fakeStoreProductDto.getPrice());
       p.setImageUrl(fakeStoreProductDto.getImageUrl());
       p.setCategory(new Category());
       p.getCategory().setName(fakeStoreProductDto.getCategory());
       return p;
   }

    private FakeStoreProductDto productToconvertFakeStoreProduct(Product product){
        FakeStoreProductDto f= new FakeStoreProductDto();
        System.out.println(product.getTitle());
        f.setTitle(product.getTitle());
        f.setDescription(product.getDescription());
        f.setPrice(product.getPrice());
        f.setImageUrl(product.getImageUrl());
        f.setCategory(product.getCategory().getName());
        return f;
    }


    @Override
    public Product getSingleProduct(Long id){
//       restTemplate.getForObject(
//               url:"https://fakestoreap.com/prodcuts/" + id,
//                responseType: null
//       );
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id,
                FakeStoreProductDto.class
        );

        return convertFakeStoreProductToProduct(fakeStoreProductDto);
    }

    @Override
    public Product addNewProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }

//    @Override
//    public FakeStoreProductDto addNewProduct(Product product){
//
//       FakeStoreProductDto fakeStoreProductDto = restTemplate.postForObject(
//               "https://fakestoreapi.com/products/",productToconvertFakeStoreProduct(product),FakeStoreProductDto.class
//       );
//
//       return fakeStoreProductDto;
//    }

//    @Override
//    public FakeStoreProductDto[] getAllProducts(){
//
//        FakeStoreProductDto fakeStoreProductDtos[] = restTemplate.getForObject(
//                "https://fakestoreapi.com/products?limit=5", FakeStoreProductDto[].class
//        );
//
//        // to limit no of records
//
////       FakeStoreProductDto fakeStoreProductDtos[] = restTemplate.getForObject(
////               "https://fakestoreapi.com/products?limit=5", FakeStoreProductDto[].class
////       );
//
//       return fakeStoreProductDtos;
//    }

//    @Override
//    public Product replaceProduct (Long id, Product product){
//        RequestCallback requestCallback = restTemplate.httpEntityCallback(productToconvertFakeStoreProduct(product), FakeStoreProductDto.class);
//        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductDto.class, restTemplate.getMessageConverters());
//        FakeStoreProductDto response =  restTemplate.execute("https://fakestoreapi.com/products/" +  id, HttpMethod.PUT, requestCallback, responseExtractor, new Object[]{});
//        return convertFakeStoreProductToProduct(response);
//    }

}
