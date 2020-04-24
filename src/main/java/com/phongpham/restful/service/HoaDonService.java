package com.phongpham.restful.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phongpham.restful.entities.Customer;
import com.phongpham.restful.entities.Dienke;
import com.phongpham.restful.entities.HoaDon;
import com.phongpham.restful.repository.HoaDonRepository;
import com.phongpham.restful.repository.dienkeRepository;
import com.phongpham.restful.service.ServiceResult.Status;

@Service
public class HoaDonService {
	@Autowired
	private HoaDonRepository hoaDonRepository;
	@Autowired
	private dienkeRepository dienkeRepository;
	
	public ServiceResult findById(int id) {
		ServiceResult result=new ServiceResult();
		result.setData(hoaDonRepository.findById(id));
		return result;
	}
	public ServiceResult create(HoaDon hoaDon,int iddienke) {
		ServiceResult result=new ServiceResult();
		Dienke dienke=dienkeRepository.findById(iddienke).orElse(null);
		if(dienke==null) {
			result.setStatus(Status.FAILED);
		      result.setMessage("Customer Not Found");
		}else {
			hoaDon.setDienke(dienke);
			result.setData(hoaDonRepository.save(hoaDon));
			  result.setMessage("Success");
		}
		return result;
	}
}
