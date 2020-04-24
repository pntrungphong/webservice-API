package com.phongpham.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phongpham.restful.entities.Dienke;
import com.phongpham.restful.service.DienKeService;
import com.phongpham.restful.service.ServiceResult;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class DienKeController {
	@Autowired
	private DienKeService dienKeService;
	
	/* ---------------- GET ALL DIENKE ------------------------ */
	@RequestMapping("/dienke")
	public ResponseEntity<ServiceResult> findAllDienKe(){
		return new ResponseEntity<ServiceResult>(dienKeService.findAll(),HttpStatus.OK);
	}
	/* ---------------- GET ALL DIENKE BY ID CUSTOMER ------------------------ */
	@RequestMapping("/dienke/customer/{customerId}")
	public ResponseEntity<ServiceResult> findByCustomerId(@PathVariable("customerId") int idCustomer){
		return new ResponseEntity<ServiceResult>(dienKeService.findByCustomerId(idCustomer),HttpStatus.OK);
		
	}
	/* ---------------- GET DIENKE BY ID AND ID CUSTOMER ------------------------ */
	@RequestMapping("/dienke/customer/{customerId}/dienke/{id}")
	public ResponseEntity<ServiceResult> findByIdAndCustomerId(@PathVariable("id") int id,@PathVariable("customerId") int idCustomer){
		return new ResponseEntity<ServiceResult>(dienKeService.findByIdAndCustomerId(id, idCustomer),HttpStatus.OK);
		
	}
	/* ---------------- POST DIENKE BY ID AND ID CUSTOMER ------------------------ */
	@PostMapping("/dienke/customer/{customerId}")
	public ResponseEntity<ServiceResult> create(@RequestBody Dienke dienke,@PathVariable("customerId") int idCustomer){
		return new ResponseEntity<ServiceResult>(dienKeService.create(dienke, idCustomer),HttpStatus.OK);
	}
	/* ---------------- PUT DIENKE BY ID AND ID CUSTOMER ------------------------ */
	@PutMapping("/dienke/customer/{customerId}/dienke/{id}")
	public ResponseEntity<ServiceResult> update(@RequestBody Dienke dienke,@PathVariable("customerId") int idCustomer,@PathVariable("id") int id ){
		return new ResponseEntity<ServiceResult>(dienKeService.update(dienke, id, idCustomer),HttpStatus.OK);
	}
	/* ---------------- DELETE DIENKE BY ID AND ID CUSTOMER ------------------------ */
	@DeleteMapping("/dienke/customer/{customerId}/dienke/{id}")
	public ResponseEntity<ServiceResult> delete(@PathVariable("customerId") int idCustomer,@PathVariable("id") int id){
		return new ResponseEntity<ServiceResult>(dienKeService.delete(id, idCustomer),HttpStatus.OK);
	}
}
