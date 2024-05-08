package com.example.thi.sevice;

import com.example.thi.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAllPr();

    void save(Product product);

    Product findById(Integer id);


    void delete(Product product);

}
