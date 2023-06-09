package com.gl.HibernateCodingChallenge.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PreRemove;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "addressId")
	private int aId;

	private String houseNo;
	private String locality;
	private String city;
	private String pincode;

//	@ManyToOne
//	@JoinColumn(name = "stuId")
	@OneToOne(mappedBy = "address")
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	@PreRemove
	private void pre() {
//		System.out.println("in addresss preremove --> " + student.getAddress());
		student.setAddress(null);
		
//		System.out.println("---------------> " + student);

	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public Address(String houseNo, String locality, String city, String pincode) {
		super();
		this.houseNo = houseNo;
		this.locality = locality;
		this.city = city;
		this.pincode = pincode;
	}

	public Address() {
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public String toString() {
		return "Address [aId=" + aId + ", houseNo=" + houseNo + ", locality=" + locality + ", city=" + city
				+ ", pincode=" + pincode + ", student=" + student + "]";
	}

	

}
