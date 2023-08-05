package repository;

import models.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    void save(Product product);
    Product  finById(int id);
    void update(int id,Product product);
    void remove(int id);

}
