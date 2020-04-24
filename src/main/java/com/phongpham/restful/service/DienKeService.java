package com.phongpham.restful.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phongpham.restful.entities.Customer;
import com.phongpham.restful.entities.Dienke;
import com.phongpham.restful.repository.CustomerRepository;
import com.phongpham.restful.repository.dienkeRepository;
import com.phongpham.restful.service.ServiceResult.Status;

@Service
public class DienKeService {
	@Autowired
	private dienkeRepository dienkeRepository;
	@Autowired
	private CustomerRepository customerRepository;
	public ServiceResult findAll() {
		ServiceResult result=new ServiceResult();
		result.setData(dienkeRepository.findAll());
		return result;
	}
	public ServiceResult findById(int id) {
		ServiceResult result=new ServiceResult();
		result.setData(dienkeRepository.findById(id));
		return result;
	}
	public ServiceResult findByCustomerId(int idCustomer) {
		ServiceResult result=new ServiceResult();
		result.setData(dienkeRepository.findByCustomerId(idCustomer));
		return result;
	}
	public ServiceResult findByIdAndCustomerId(int id,int idCustomer) {
		ServiceResult result=new ServiceResult();
		result.setData(dienkeRepository.findByIdAndCustomerId(id, idCustomer));
		return result;
	}
	public ServiceResult create(Dienke dienke,int idCustomer) {
		ServiceResult result=new ServiceResult();
		Customer customer=customerRepository.findById(idCustomer).orElse(null);
		if(customer==null) {
			result.setStatus(Status.FAILED);
		      result.setMessage("Customer Not Found");
		}else {
			dienke.setCustomer(customer);
			result.setData(dienkeRepository.save(dienke));
			  result.setMessage("abc");
		}
		return result;
	}
	public ServiceResult update(Dienke dienke,int id,int idCustomer) {
		ServiceResult result=new ServiceResult();
		Customer customer=customerRepository.findById(idCustomer).orElse(null);
		
		if(customer==null) {
			result.setStatus(Status.FAILED);
		    result.setMessage("Customer Not Found");
		}else {
			if(!dienkeRepository.findById(id).isPresent()) {
				result.setStatus(Status.FAILED);
			    result.setMessage("Dien ke Not Found");
			}else {
				dienke.setId(id);
				result.setData(dienkeRepository.save(dienke));
			}
			
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ServiceResult delete(int id,int idCustomer) {
		ServiceResult result=new ServiceResult();
		Dienke dienke=dienkeRepository.findByIdAndCustomerId(id, idCustomer).orElse(null);
		if(dienke==null) {
			result.setStatus(Status.FAILED);
		    result.setMessage("Customer Not Found with id: "+idCustomer+" and dien ke Not Found with id: "+id);
		}else {
			dienkeRepository.delete(dienke);;
			result.setMessage("success");
		}
		return result;
	}
}

















