package com.phongpham.restful.entities;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="dienke")
public class Dienke {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="thang")
	private int thang;
	@Column(name="cscu")
	private float cscu;
	@Column(name="csmoi")
	private float csmoi;
	@Column(name="trangthai")
	private boolean trangthai;
	@ManyToOne
	@JoinColumn(name="idcustomer")
	@JsonBackReference
	private Customer customer;
	@OneToMany(mappedBy = "dienke")
	@JsonManagedReference
	private List<HoaDon> listHoaDon;
	
	public Dienke() {
		
	}


	public Dienke(int id, int thang, float cscu, float csmoi, boolean trangthai, Customer customer,
			List<HoaDon> listHoaDon) {
		super();
		this.id = id;
		this.thang = thang;
		this.cscu = cscu;
		this.csmoi = csmoi;
		this.trangthai = trangthai;
		this.customer = customer;
		this.listHoaDon = listHoaDon;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getThang() {
		return thang;
	}

	public void setThang(int thang) {
		this.thang = thang;
	}

	public float getCscu() {
		return cscu;
	}

	public void setCscu(float cscu) {
		this.cscu = cscu;
	}

	public float getCsmoi() {
		return csmoi;
	}

	public void setCsmoi(float csmoi) {
		this.csmoi = csmoi;
	}

	public boolean isTrangthai() {
		return trangthai;
	}

	public void setTrangthai(boolean trangthai) {
		this.trangthai = trangthai;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public List<HoaDon> getListHoaDon() {
		return listHoaDon;
	}


	public void setListHoaDon(List<HoaDon> listHoaDon) {
		this.listHoaDon = listHoaDon;
	}
	
	
	
}
