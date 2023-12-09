package com.example.baitapSpring.Service.imp;

import com.example.baitapSpring.dto.CustomerDTO;
import com.example.baitapSpring.entity.CustomerEntity;

import java.util.List;

public interface CustomertIMP {

    List<CustomerEntity> create(String name, String email);
    List<CustomerDTO> getAll();

    List<CustomerDTO>findByIdCustomer(int id);
}
