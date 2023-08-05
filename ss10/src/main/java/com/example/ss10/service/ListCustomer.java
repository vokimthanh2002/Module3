package com.example.ss10.service;

import com.example.ss10.Customer;

import java.util.ArrayList;
import java.util.List;

public class ListCustomer {
    public static List<Customer> customerList = new ArrayList<>();
    static {
        customerList.add(new Customer("Vo Kim Thanh","04/02/2002","Quang Nam",""));
        customerList.add(new Customer("Vo Kim Thanh","04/02/2002","Quang Nam",""));
        customerList.add(new Customer("Vo Kim Thanh","04/02/2002","Quang Nam","hinhanh.jpg"));
        customerList.add(new Customer("Vo Kim Thanh","04/02/2002","Quang Nam","hinhanh.jpg"));
        customerList.add(new Customer("Vo Kim Thanh","04/02/2002","Quang Nam","hinhanh.jpg"));
    }


}
