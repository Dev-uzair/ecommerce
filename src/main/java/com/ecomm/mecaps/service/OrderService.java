package com.ecomm.mecaps.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecomm.mecaps.model.Order;
@Service
public interface OrderService {

	ResponseEntity<String> add(Order order);

	ResponseEntity<List<Order>> findAll();

	ResponseEntity<Order> findById(long id);

	ResponseEntity<String> deleteById(long id);

	ResponseEntity<String> updateById(long id, Order order);

}
