package repository;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImp implements CustomerRepository{
    public static List<Customer> customerList;
    static {
        customerList = new ArrayList<>();
        customerList.add(new Customer(1,"6","vothanh6081@gmail.com","Viet Nam"));
        customerList.add(new Customer(2,"7","vothanh6081@gmail.com","Viet Nam"));
        customerList.add(new Customer(3,"8","vothanh6081@gmail.com","Viet Nam"));
        customerList.add(new Customer(4,"9","vothanh6081@gmail.com","Viet Nam"));
        customerList.add(new Customer(5,"10","vothanh6081@gmail.com","Viet Nam"));
    }
    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public Customer finById(int id) {
        Customer customer1 = null;
      for(Customer customer: customerList){
          if(customer.getId()==id){
              customer1=customer;
          }
      }
      return customer1;
    }

    @Override
    public void update(int id, Customer customer) {
       customerList.set(id,customer);
    }

    @Override
    public void remove(int id) {
        customerList.remove(id);
    }
}
