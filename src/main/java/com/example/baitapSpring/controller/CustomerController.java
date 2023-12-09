package com.example.baitapSpring.controller;

import com.example.baitapSpring.Service.imp.CustomertIMP;
import com.example.baitapSpring.dto.CustomerDTO;
import com.example.baitapSpring.entity.CustomerEntity;
import com.example.baitapSpring.payload.response.BaseResponse;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/client")
public class CustomerController {

    @Autowired
    private CustomertIMP customertIMP;

    private Gson gson = new Gson();

    private Logger logger = LoggerFactory.getLogger(CustomerController.class);

    //1.	Tạo một RESTful API để thêm khách hàng mới vào danh sách.
    @PostMapping("")
    public ResponseEntity<?> CreateCustomer(@RequestParam String name,@RequestParam String email){
        List<CustomerEntity> list = customertIMP.create(name,email);
       logger.info("Kiểm tra " + list);
       return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //2.	Tạo một RESTful API để lấy danh sách tất cả khách hàng.
    @GetMapping("/getall")
    public ResponseEntity<?> getAllCustomer(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(customertIMP.getAll());
        return new ResponseEntity<>(baseResponse,HttpStatus.OK);
    }

    //3.	Tạo một RESTful API để lấy thông tin của một khách hàng theo Id.
    @GetMapping("/demo/{id}")
    public ResponseEntity<?> finbyIdCustomer(@PathVariable int id){
        List<CustomerDTO> list = customertIMP.findByIdCustomer(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }





}

