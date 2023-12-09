package com.example.baitapSpring.Service;

import com.example.baitapSpring.Service.imp.OrdersIMP;
import com.example.baitapSpring.entity.CustomerEntity;
import com.example.baitapSpring.entity.OrdersEntity;
import com.example.baitapSpring.repository.OdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OdersService implements OrdersIMP {

    @Autowired
    private OdersRepository odersRepository;

    @Override
    public OrdersEntity oderIdCustomer(int idCustomer, String oderCode, double price) {
        OrdersEntity orders = new OrdersEntity();
        orders.setOrderCode(oderCode);
        orders.setTotalAmount(price);

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(idCustomer);
        orders.setCustomer(customerEntity);

        return odersRepository.save(orders);
    }

    @Override
    public List<OrdersEntity> finAllByIdCustomer(int id) {
        List<OrdersEntity> list = odersRepository.findByCustomerId(id);

        OrdersEntity ordersEntity = new OrdersEntity();

        CustomerEntity customer = new CustomerEntity();
        customer.setId(id);
        ordersEntity.setCustomer(customer);
        list.add(ordersEntity);

        return list;
    }
}
