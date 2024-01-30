package com.ecomm.mecaps.contoller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.mecaps.model.Order;
import com.ecomm.mecaps.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderService orderService;
	//add
	@PostMapping("/add")
	public ResponseEntity<String> addOrder(@RequestBody Order order){
		return orderService.add(order);
	}
	@GetMapping("/")
	public ResponseEntity<List<Order>> findAll(){
		return orderService.findAll();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Order> findById(@PathVariable long id){
		return orderService.findById(id);
			}
	
	@DeleteMapping("/{id}") 
	public ResponseEntity<String> deleteById(@PathVariable long id){
		return orderService.deleteById(id);
	}
	@PutMapping("/{id}")
	public ResponseEntity<String> updateById(@PathVariable long id,@RequestBody Order order){
		return orderService.updateById(id,order);
	}
}
