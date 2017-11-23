package com.nisum.mytime.model;

public class EmployeeDetails {

	private String employeeid;
	private String employeeName;
	private String gender;
	private String designation;
	private String contactNo;
	private String email;
	private String workPlace;
	private String team;
	private String shiftGroupId;
	private String shiftRosterId;

	public String getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWorkPlace() {
		return workPlace;
	}

	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getShiftGroupId() {
		return shiftGroupId;
	}

	public void setShiftGroupId(String shiftGroupId) {
		this.shiftGroupId = shiftGroupId;
	}

	public String getShiftRosterId() {
		return shiftRosterId;
	}

	public void setShiftRosterId(String shiftRosterId) {
		this.shiftRosterId = shiftRosterId;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [employeeid=" + employeeid + ", employeeName=" + employeeName + ", gender=" + gender
				+ ", designation=" + designation + ", contactNo=" + contactNo + ", email=" + email + ", workPlace="
				+ workPlace + ", team=" + team + ", shiftGroupId=" + shiftGroupId + ", shiftRosterId=" + shiftRosterId
				+ "]";
	}
	
	

}
