package com.example.baitapSpring.Service;

import com.example.baitapSpring.Service.imp.CustomertIMP;
import com.example.baitapSpring.dto.CustomerDTO;
import com.example.baitapSpring.entity.CustomerEntity;
import com.example.baitapSpring.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements CustomertIMP {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerEntity> create(String name, String email) {
        CustomerEntity customer = new CustomerEntity();
        customer.setName(name);
        customer.setEmail(email);
        customerRepository.save(customer);
        return null;
    }

    @Override
    public List<CustomerDTO> getAll() {
        List<CustomerDTO> dtoList = new ArrayList<>();
        List<CustomerEntity> list = customerRepository.findAll();
        for (CustomerEntity items: list) {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setId(items.getId());
            customerDTO.setName(items.getName());
            customerDTO.setEmail(items.getEmail());
            dtoList.add(customerDTO);
        }
        return dtoList;
    }

    @Override
    public List<CustomerDTO> findByIdCustomer(int id) {
        List<CustomerDTO> listDTO = new ArrayList<>();
        Optional<CustomerEntity> customerEntityList = customerRepository.findById(id);
        if (customerEntityList.isPresent()){
            CustomerEntity customerEntity = customerEntityList.get();
                CustomerDTO customerDTO = new CustomerDTO();
                customerDTO.setId(customerEntity.getId());
                customerDTO.setName(customerEntity.getName());
                customerDTO.setEmail(customerEntity.getEmail());
                listDTO.add(customerDTO);
        }



        return listDTO;
    }
}
