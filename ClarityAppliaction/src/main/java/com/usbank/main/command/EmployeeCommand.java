package com.usbank.main.command;

public class EmployeeCommand {
	
	private Long empid;
	private String empName;
	private Integer clarityHours;
	private Integer leaveCount;
	private Integer holidayCount;
	private String comments;
	
	public EmployeeCommand() {
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

	@Override
	public String toString() {
		return "EmployeeCommand [empid=" + empid + ", empName=" + empName + ", clarityHours=" + clarityHours
				+ ", leaveCount=" + leaveCount + ", holidayCount=" + holidayCount + ", comments=" + comments + "]";
	}

	
	
	

}
