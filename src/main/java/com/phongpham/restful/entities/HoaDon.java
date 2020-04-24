package com.phongpham.restful.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="hoadon")
public class HoaDon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@ManyToOne
	@JoinColumn(name="iddienke")
	@JsonBackReference
	private Dienke dienke;
	@Column(name="date")
	private Date date;
	public HoaDon(int id, Dienke dienke, Date date) {
		super();
		this.id = id;
		this.dienke = dienke;
		this.date = date;
	}
	public HoaDon() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Dienke getDienke() {
		return dienke;
	}
	public void setDienke(Dienke dienke) {
		this.dienke = dienke;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
