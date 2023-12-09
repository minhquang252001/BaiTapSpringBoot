package com.example.baitapSpring.Service.imp;

import com.example.baitapSpring.entity.OrdersEntity;

import java.util.List;

public interface OrdersIMP {

    OrdersEntity oderIdCustomer(int idCustomer,String oderCode, double price);

    List<OrdersEntity> finAllByIdCustomer(int id);
}
