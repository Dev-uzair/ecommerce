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


import com.ecomm.mecaps.model.Category;
import com.ecomm.mecaps.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	// add
	@PostMapping("/add")
	public ResponseEntity<String> addCategory(@RequestBody Category category) {
return categoryService.addCategory(category);
	}

	// get all
	@GetMapping("/")
	public ResponseEntity<List<Category>> findAll(){
		return categoryService.findAll();
	}
	// get by id
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> findById(@PathVariable long id){
		return categoryService.findById(id);
			}
	
	// delete
	
	@DeleteMapping("/{id}") 
	public ResponseEntity<String> deleteById(@PathVariable long id){
		return categoryService.deleteById(id);
	}
	// update

	@PutMapping("/{id}")
	public ResponseEntity<String> updateById(@PathVariable long id,@RequestBody Category category){
		return categoryService.updateById(id,category);
	}
}
