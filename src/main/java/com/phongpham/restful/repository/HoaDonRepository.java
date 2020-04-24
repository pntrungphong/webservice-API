package com.phongpham.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phongpham.restful.entities.HoaDon;
@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Integer> {

}
