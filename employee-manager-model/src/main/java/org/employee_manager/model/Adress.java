package org.employee_manager.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ADRESS")
public class Adress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ADRESS_ID")
	private long id;

	@Column(name = "ADRESS_CODE")
	private String code;

	@Column(name = "ADRESS_STREET")
	private int street;

	@Column(name = "ADRESS_STREET_NO")
	private int streetNo;

	@Column(name = "ADRESS_CITY")
	private String city;

	@Column(name = "ADRESS_COUNTRY")
	private String Country;

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "EMPLOYEE_ID")
//	private Employee employee;

	public Adress() {

	}

	public int getStreet() {
		return street;
	}

	public void setStreet(int street) {
		this.street = street;
	}

//WHEN EMPLOYEE APPEARS!
//	public Employee getEmployee() {
//		return employee;
//	}
//
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(int streetNo) {
		this.streetNo = streetNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

}
