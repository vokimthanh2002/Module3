package repository;

import model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
    void save(Customer customer);
    Customer finById(int id);
    void update(int id, Customer customer);
    void remove(int id);
}
