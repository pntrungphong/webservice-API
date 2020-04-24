package com.phongpham.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phongpham.restful.entities.Admin;
import com.phongpham.restful.service.AdminService;
import com.phongpham.restful.service.ServiceResult;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	@RequestMapping("/{id}")
	public ResponseEntity<ServiceResult> findById(@PathVariable("id") int id){
		return new ResponseEntity<ServiceResult>(adminService.findById(id),HttpStatus.OK);
	}
	@PostMapping("/create")
	public ResponseEntity<ServiceResult> create(@RequestBody Admin admin){
		return new ResponseEntity<ServiceResult>(adminService.create(admin),HttpStatus.OK);
	}
}
