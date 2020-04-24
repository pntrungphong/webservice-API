package com.phongpham.restful.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	 @Size(min=2, message="Name should have atleast 2 characters")
	@Column(name="name")
	private String name;
	@NotBlank(message="Dia chi trong")
	@Column(name="address")
	private String address;
	@Column(name="phone")
	private String phone;
	@OneToMany(mappedBy = "customer")
	@JsonManagedReference
	private List<Dienke> dienke;


	public Customer(int id, String name, String address, String phone, List<Dienke> dienke) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.dienke = dienke;
	}
	public Customer() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public List<Dienke> getDienke() {
		return dienke;
	}
	public void setDienke(List<Dienke> dienke) {
		this.dienke = dienke;
	}

	
	
}
