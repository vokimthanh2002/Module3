package service;

import models.Product;
import repository.IProductRepository;
import repository.ProductRepository;

import java.util.List;

public class IProductService implements ProductService{
    ProductRepository productRepository = new IProductRepository();



    @Override
    public List<Product> findAll() {
      return  productRepository.findAll();
    }

    @Override
    public void save(Product product) {
       productRepository.save(product);
    }

    @Override
    public Product finById(int id) {
        return productRepository.finById(id);
    }


    @Override
    public void update(int id,Product product) {
        productRepository.update(id,product);
    }

    @Override
    public void remove(int id) {
        productRepository.remove(id);

    }
}
