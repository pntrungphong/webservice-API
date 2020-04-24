package com.phongpham.restful.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phongpham.restful.entities.Admin;
import com.phongpham.restful.repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;
	
	public ServiceResult findById(int id) {
		ServiceResult result=new ServiceResult();
		result.setData(adminRepository.findById(id));
		return result;
	}
	public ServiceResult create(Admin admin) {
		ServiceResult resutl=new ServiceResult();
		resutl.setData(adminRepository.save(admin));
		return resutl;
	}
}
