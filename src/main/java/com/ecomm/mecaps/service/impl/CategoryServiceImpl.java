package com.ecomm.mecaps.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecomm.mecaps.dao.CategoryRepository;
import com.ecomm.mecaps.model.Category;
import com.ecomm.mecaps.service.CategoryService;

import jakarta.transaction.Transactional;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	@Transactional
	@Override
	public ResponseEntity<String> addCategory(Category category) {
		try {

			categoryRepository.save(category);
			return new ResponseEntity<>("Added >" + category.getCategoryId(), HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<List<Category>> findAll() {
		try {
			
			return new ResponseEntity<>(categoryRepository.findAll() ,HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<Category> findById(long id) {
		try {
			return new ResponseEntity<>(categoryRepository.findById(id).get(),HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>( new Category() ,HttpStatus.OK);
	}
@Transactional
	@Override
	public ResponseEntity<String> deleteById(long id) {
		try {
			
			categoryRepository.deleteById(id);
			return new ResponseEntity<>(" deleted ",HttpStatus.ACCEPTED);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>("id not found ",HttpStatus.BAD_GATEWAY);
	}

	@Override
	public ResponseEntity<String> updateById(long id, Category category) {
			try {
				category.setCategoryId(id);
				categoryRepository.save(category);
				return new ResponseEntity<>("updated successfully", HttpStatus.CREATED);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new ResponseEntity<>("some thing went wrong in update", HttpStatus.BAD_GATEWAY);
	}

}
