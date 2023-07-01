package com.idcard.school.model;

import java.util.Arrays;

public class IDCardWrapper {

	private String serialNumber;
	private String name;
	private String fatherName;
	private String gender;
	private String dob;
	private String universityName;
	private String collegeName;
	private String degree;
	private String session;
	private String mobile;
	private String email;
	private byte [] image;
	
	
	
	public IDCardWrapper() {
		super();
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		return "IDCardWrapper [serialNumber=" + serialNumber + ", name=" + name + ", fatherName=" + fatherName
				+ ", gender=" + gender + ", dob=" + dob + ", universityName=" + universityName + ", collegeName="
				+ collegeName + ", degree=" + degree + ", session=" + session + ", mobile=" + mobile + ", email="
				+ email + ", image=" + Arrays.toString(image) + "]";
	}
	
	
	
}
