package com.phongpham.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phongpham.restful.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>  {

}
