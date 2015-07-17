package org.employee_manager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable {

	@Id
	@Column(name = "ADDRESS_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN_ADDRESS")
	@SequenceGenerator(name = "SEQ_GEN_ADDRESS", sequenceName = "address_id_sequence", allocationSize = 10)
	private long id;

	@Column(name = "ADDRESS_CODE")
	private String code;

	@Column(name = "ADDRESS_STREET")
	private int street;

	@Column(name = "ADDRESS_STREET_NO")
	private int streetNo;

	@Column(name = "ADDRESS_CITY")
	private String city;

	@Column(name = "ADDRESS_COUNTRY")
	private String Country;

	@OneToOne(mappedBy = "addressId")
	private Employee employee;

	public int getStreet() {
		return street;
	}

	public void setStreet(int street) {
		this.street = street;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

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
