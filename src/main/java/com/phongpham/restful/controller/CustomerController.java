package com.phongpham.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import com.phongpham.restful.entities.Customer;
import com.phongpham.restful.service.CustomerService;
import com.phongpham.restful.service.ServiceResult;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	/* ---------------- GET ALL CUSTOMER ------------------------ */
	@GetMapping("/customers")
	public ResponseEntity<ServiceResult> findAllCustomer(){
		return new ResponseEntity<ServiceResult>(customerService.findAll(),HttpStatus.OK);
	}
	  /* ---------------- GET CUSTOMER BY NAME ------------------------ */
	@GetMapping("/customers/name/{name}")
	public ResponseEntity<ServiceResult> findByName(@PathVariable("name") String name){
		return new ResponseEntity<ServiceResult>(customerService.findByName(name),HttpStatus.OK);
	}
	  /* ---------------- GET CUSTOMER BY ID ------------------------ */
	@GetMapping("/customers/{id}")
	public ResponseEntity<ServiceResult> findById(@PathVariable int id){
		return new ResponseEntity<ServiceResult>(customerService.findById(id),HttpStatus.OK);
	}
	  /* ---------------- CREATE NEW CUSTOMER ------------------------ */
	@PostMapping("/customers")
	public ResponseEntity<ServiceResult> create(@Valid @RequestBody Customer customer){
		return new ResponseEntity<ServiceResult>(customerService.create(customer),HttpStatus.OK);
	}	
	/* ---------------- UPDATE CUSTOMER ------------------------ */
	public ResponseEntity<ServiceResult> update(@RequestBody UpdateCustomerRequest request){
		return new ResponseEntity<ServiceResult>(customerService.update(request.getCustomer()),HttpStatus.OK);
	}
	/* ---------------- DELETE CUSTOMER ------------------------ */
	public ResponseEntity<ServiceResult> delete(@RequestBody DeleteCustomerRequest request){
		return new ResponseEntity<ServiceResult>(customerService.delete(request.getId()),HttpStatus.OK);
	}

}
