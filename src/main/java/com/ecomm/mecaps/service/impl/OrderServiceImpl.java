package com.ecomm.mecaps.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ecomm.mecaps.dao.OrderRepository;
import com.ecomm.mecaps.model.Order;
import com.ecomm.mecaps.service.OrderService;

import jakarta.transaction.Transactional;

public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	@Transactional
	@Override
	public ResponseEntity<String> add(Order order) {
		try {

			orderRepository.save(order);
			return new ResponseEntity<>("Added >" + order.getOrderId(), HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<List<Order>> findAll() {
try {
			
			return new ResponseEntity<>(orderRepository.findAll() ,HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<Order> findById(long id) {
		try {
			return new ResponseEntity<>(orderRepository.findById(id).get(),HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>( new Order() ,HttpStatus.OK);
	}
	@Transactional
	@Override
	public ResponseEntity<String> deleteById(long id) {
	try {
			
			orderRepository.deleteById(id);
			return new ResponseEntity<>(" deleted ",HttpStatus.ACCEPTED);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>("id not found ",HttpStatus.BAD_GATEWAY);
	}

	@Override
	public ResponseEntity<String> updateById(long id, Order order) {
		try {
			order.setOrderId(id);
			orderRepository.save(order);
			return new ResponseEntity<>("updated successfully", HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>("some thing went wrong in update", HttpStatus.BAD_GATEWAY);
	}
	
	

}
