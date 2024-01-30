package com.ecomm.mecaps.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecomm.mecaps.model.Category;

@Service
public interface CategoryService {

	ResponseEntity<String> addCategory(Category category);

	ResponseEntity<List<Category>> findAll();

	ResponseEntity<Category> findById(long id);

	ResponseEntity<String> deleteById(long id);

	ResponseEntity<String> updateById(long id, Category category);

}
