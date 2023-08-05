package service;

import model.Customer;
import repository.CustomerRepository;
import repository.CustomerRepositoryImp;

import java.util.List;

public class CustomerServiceImp implements CustomerService {
    CustomerRepository customerRepository = new CustomerRepositoryImp();


    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer finById(int id) {
        return customerRepository.finById(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerRepository.update(id,customer);
    }

    @Override
    public void remove(int id) {
        customerRepository.remove(id);
    }
}
