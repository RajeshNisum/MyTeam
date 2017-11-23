package com.nisum.mytime.model;

public class EmpLoginData {

	private String employeeid;
	private String employeeName;
	private String Userid;
	private String firstLogin;
	private String lastLogout;
	private String totalLoginTime;
	private String direction;

	public String getUserid() {
		return Userid;
	}

	public void setUserid(String userid) {
		Userid = userid;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getFirstLogin() {
		return firstLogin;
	}

	public void setFirstLogin(String firstLogin) {
		this.firstLogin = firstLogin;
	}

	public String getLastLogout() {
		return lastLogout;
	}

	public void setLastLogout(String lastLogout) {
		this.lastLogout = lastLogout;
	}

	public String getTotalLoginTime() {
		return totalLoginTime;
	}

	public void setTotalLoginTime(String totalLoginTime) {
		this.totalLoginTime = totalLoginTime;
	}

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

	@Override
	public String toString() {
		return "EmpLoginData [employeeid=" + employeeid + ", employeeName=" + employeeName + ", Userid=" + Userid
				+ ", firstLogin=" + firstLogin + ", lastLogout=" + lastLogout + ", totalLoginTime=" + totalLoginTime
				+ ", direction=" + direction + "]";
	}

}
