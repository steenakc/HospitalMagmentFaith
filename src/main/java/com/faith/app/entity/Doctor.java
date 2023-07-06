package com.faith.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer doctorId;
	
	private String  doctorName;
	
	private String gender;
	 
	private boolean isActive;
	
	private Double consultationFee;
	
	private Integer maxOpVisits;
	
	private Integer userId;
	@OneToOne
	@JoinColumn(name="userId",insertable = false,updatable = false)
	private User user;
	
	private Integer deptId;
	@ManyToOne
	@JoinColumn(name="deptId",insertable = false,updatable = false)
	private Department department;

	
	public Doctor() {
		super();
		
		// TODO Auto-generated constructor stub
	}

	
	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Double getConsultationFee() {
		return consultationFee;
	}

	public void setConsultationFee(Double consultationFee) {
		this.consultationFee = consultationFee;
	}

	public Integer getMaxOpVisits() {
		return maxOpVisits;
	}

	public void setMaxOpVisits(Integer maxOpVisits) {
		this.maxOpVisits = maxOpVisits;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}


	
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", gender=" + gender + ", isActive="
				+ isActive + ", consultationFee=" + consultationFee + ", maxOpVisits=" + maxOpVisits + ", userId="
				+ userId + ", user=" + user + ", deptId=" + deptId + ", department=" + department + "]";
	}
	

}
