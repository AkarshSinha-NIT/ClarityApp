package com.usbank.main.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {
	
	private static final long serialVersionUID = 4302213077465325922L;

	@Id
	@Column(name = "EMPID", unique = true, nullable = false)
	@Type(type = "long")
	private Long empid;
	
	@Column(name = "EMPNAME", length = 20 )
	@Type(type = "string")
	private String empName;
	
	@Column(name = "CLARITYHOURS",  nullable = false)
	@Type(type = "int")
	private Integer clarityHours;
	
	@Column(name = "LEAVECOUNT")
	@Type(type = "int")
	private Integer leaveCount;
	
	@Column(name = "HOLIDAYCOUNT")
	@Type(type = "int")
	private Integer holidayCount;
	
	@Column(name = "COMMENTS", length = 50)
	@Type(type = "string")
	private String comments;
	

	public Employee() {
	}


	public Employee(Long empid, String empName, Integer clarityHours, Integer leaveCount, Integer holidayCount,
			String comments) {
		this.empid = empid;
		this.empName = empName;
		this.clarityHours = clarityHours;
		this.leaveCount = leaveCount;
		this.holidayCount = holidayCount;
		this.comments = comments;
	}


	public Long getEmpid() {
		return empid;
	}


	public void setEmpid(Long empid) {
		this.empid = empid;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public Integer getClarityHours() {
		return clarityHours;
	}


	public void setClarityHours(Integer clarityHours) {
		this.clarityHours = clarityHours;
	}


	public Integer getLeaveCount() {
		return leaveCount;
	}


	public void setLeaveCount(Integer leaveCount) {
		this.leaveCount = leaveCount;
	}


	public Integer getHolidayCount() {
		return holidayCount;
	}


	public void setHolidayCount(Integer holidayCount) {
		this.holidayCount = holidayCount;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clarityHours == null) ? 0 : clarityHours.hashCode());
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		result = prime * result + ((empid == null) ? 0 : empid.hashCode());
		result = prime * result + ((holidayCount == null) ? 0 : holidayCount.hashCode());
		result = prime * result + ((leaveCount == null) ? 0 : leaveCount.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (clarityHours == null) {
			if (other.clarityHours != null)
				return false;
		} else if (!clarityHours.equals(other.clarityHours))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		if (empid == null) {
			if (other.empid != null)
				return false;
		} else if (!empid.equals(other.empid))
			return false;
		if (holidayCount == null) {
			if (other.holidayCount != null)
				return false;
		} else if (!holidayCount.equals(other.holidayCount))
			return false;
		if (leaveCount == null) {
			if (other.leaveCount != null)
				return false;
		} else if (!leaveCount.equals(other.leaveCount))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empName=" + empName + ", clarityHours=" + clarityHours + ", leaveCount="
				+ leaveCount + ", holidayCount=" + holidayCount + ", comments=" + comments + "]";
	}
	
	
	
	
}
