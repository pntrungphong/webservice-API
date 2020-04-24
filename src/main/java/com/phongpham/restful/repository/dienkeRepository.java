package com.phongpham.restful.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phongpham.restful.entities.Dienke;

public interface dienkeRepository extends JpaRepository<Dienke, Integer> {
	List<Dienke> findByCustomerId(int idCustomer);
	Optional<Dienke> findByIdAndCustomerId(int idDienke,int idCustomer);
}
