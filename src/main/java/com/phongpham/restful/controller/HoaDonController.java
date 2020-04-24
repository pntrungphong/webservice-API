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

import com.phongpham.restful.entities.HoaDon;
import com.phongpham.restful.service.HoaDonService;
import com.phongpham.restful.service.ServiceResult;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/thanhtoan/hoadon")
public class HoaDonController {
	@Autowired
	private HoaDonService hoaDonService;
	/* ---------------- GET HOADON BY ID ------------------------ */
	@RequestMapping("/{id}")
	public ResponseEntity<ServiceResult> findById(@PathVariable("id") int id){
		return new ResponseEntity<ServiceResult>(hoaDonService.findById(id),HttpStatus.OK);
	}
	/* ---------------- CREATE HOADON ------------------------ */
	@PostMapping("/create/{iddienke}")
	public ResponseEntity<ServiceResult> create(@RequestBody HoaDon hoaDon,@PathVariable("iddienke") int iddienke){
		return new ResponseEntity<ServiceResult>(hoaDonService.create(hoaDon,iddienke),HttpStatus.OK);
	}
}
