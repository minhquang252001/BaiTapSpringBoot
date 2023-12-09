package com.example.baitapSpring.controller;

import com.example.baitapSpring.Service.imp.OrdersIMP;
import com.example.baitapSpring.entity.CustomerEntity;
import com.example.baitapSpring.entity.OrdersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("oders")
public class OdersController {

    @Autowired
    private OrdersIMP ordersIMP;

    //4.	Tạo một RESTful API để tạo đơn hàng mới và liên kết nó với một khách hàng dựa trên Id khách hàng.
        @PostMapping("")
        public ResponseEntity<?> oderByIdCustomer( @RequestParam String oderCode, @RequestParam double totalAmout,@RequestParam int idCustomer){
          try{
              OrdersEntity orders = ordersIMP.oderIdCustomer(idCustomer,oderCode,totalAmout);
              orders.setOrderCode(oderCode);
              orders.setTotalAmount(totalAmout);

              CustomerEntity customer = new CustomerEntity();
              customer.setId(idCustomer);
              orders.setCustomer(customer);
              return new ResponseEntity<>(orders,HttpStatus.OK);
          }catch (Exception e){
                throw new RuntimeException("Lỗi oderByIdCustomer " + e);
          }

        }
        // 5.	Tạo một RESTful API để lấy danh sách đơn hàng của một khách hàng theo Id khách hàng.
        @PostMapping("/demo")
        public ResponseEntity<?> finByIdCustomer(@RequestParam int id){
            List<OrdersEntity> ordersEntity =
                    ordersIMP.finAllByIdCustomer(id);
            return new ResponseEntity<>(ordersEntity, HttpStatus.OK);
        }
}
