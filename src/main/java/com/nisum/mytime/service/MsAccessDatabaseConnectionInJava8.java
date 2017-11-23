package com.nisum.mytime.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nisum.mytime.model.EmpLoginData;

public class MsAccessDatabaseConnectionInJava8 {

	public static List<EmpLoginData> fetchEmployeesData() throws FileNotFoundException {

		long start_ms = System.currentTimeMillis();
		List<EmpLoginData> loginsData = new ArrayList<>();
		Map<String, List<EmpLoginData>> map = new HashMap<>();
		String filePath = "mdbfiles/";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		} catch (ClassNotFoundException cnfex) {
			System.out.println("Problem in loading or " + "registering MS Access JDBC driver");
			cnfex.printStackTrace();
		}
		try {
			File dir = new File(filePath);
			for (File file : dir.listFiles()) {
				String msAccDB = filePath + file.getName();
				String dbURL = "jdbc:ucanaccess://" + msAccDB;
				connection = DriverManager.getConnection(dbURL);
				statement = connection.createStatement();
				resultSet = statement.executeQuery("SELECT * FROM DeviceLogs_10_2017");
				while (resultSet.next()) {
					if (resultSet.getString(4).length() >= 5) {
						EmpLoginData loginData = new EmpLoginData();
						loginData.setUserid(resultSet.getString(4));
						loginData.setFirstLogin(resultSet.getString(5));
						loginData.setDirection(resultSet.getString(6));
						loginsData.add(loginData);
					}
				}
			}
			System.out.println(loginsData.size());

			for (EmpLoginData empLoginData : loginsData) {
				getSingleEmploginData(loginsData, map, empLoginData);
			}
			System.out.println(" Taking time to do all operation " + (System.currentTimeMillis() - start_ms));

		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		} finally {
			try {
				if (null != connection) {
					resultSet.close();
					statement.close();
					connection.close();
				}
			} catch (SQLException sqlex) {
				sqlex.printStackTrace();
			}
		}
		return null;
	}

	public static List<EmpLoginData> fetchEmployeeDataBasedOnEmpId(long id)
			throws FileNotFoundException, ParseException {

		long start_ms = System.currentTimeMillis();
		List<EmpLoginData> loginsData = new ArrayList<>();
		boolean first = true;
		boolean frstQuery = true;
		List<String> dates = new ArrayList<>();
		List<String> firstAndLastLoginDates = new ArrayList<>();
		Map<String, EmpLoginData> empMap = new HashMap<>();
		String dateOnly = null;
		String empDatestr = null;
		EmpLoginData empDetails = new EmpLoginData();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateFormat tdf = new SimpleDateFormat("HH:mm:ss");
		DateFormat dfmt = new SimpleDateFormat("yyyy-MM-dd");

		String filePath = "/MOSAIC PROJECT WORKSPACE/MyTime/src/main/resources/mdbfiles/";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		} catch (ClassNotFoundException cnfex) {
			System.out.println("Problem in loading or " + "registering MS Access JDBC driver");
			cnfex.printStackTrace();
		}
		try {
			File dir = new File(filePath);
			for (File file : dir.listFiles()) {
				System.out.println(file.getName());
				String msAccDB = filePath + file.getName();
				String dbURL = "jdbc:ucanaccess://" + msAccDB;
				connection = DriverManager.getConnection(dbURL);
				statement = connection.prepareStatement("SELECT * FROM DeviceLogs_10_2017 Where USERID=?");
				statement.setLong(1, id);
				resultSet = statement.executeQuery();

				if (frstQuery) {
					PreparedStatement statement1 = connection
							.prepareStatement("SELECT * FROM EMPLOYEES Where EMPLOYEECODE=?");
					statement1.setLong(1, id);
					ResultSet resultSet1 = statement1.executeQuery();
					while (resultSet1.next() && frstQuery) {
						empDetails.setEmployeeName(resultSet1.getString(2));
						frstQuery = false;
					}
				}

				while (resultSet.next()) {
					if (resultSet.getString(4).length() >= 5) {
						EmpLoginData loginData = new EmpLoginData();
						loginData.setEmployeeName(empDetails.getEmployeeName());
						loginData.setEmployeeid(resultSet.getString(4));
						loginData.setUserid(resultSet.getString(4));
						loginData.setFirstLogin(resultSet.getString(5));
						loginData.setDirection(resultSet.getString(6));
						loginsData.add(loginData);
					}
				}
			}
			System.out.println(loginsData.size());

			for (EmpLoginData empLoginData : loginsData) {
				if (first) {
					empDatestr = empLoginData.getFirstLogin();
					Date dt = df.parse(empDatestr);
					String timeOnly = tdf.format(dt);
					dateOnly = dfmt.format(dt);
					dates.add(timeOnly);
					firstAndLastLoginDates.add(df.parse(empDatestr)+"");
					empMap.put(dateOnly, empLoginData);
					first = false;
				} else {
					empDatestr = empLoginData.getFirstLogin();
					Date dt = df.parse(empDatestr);
					String timeOnly = tdf.format(dt);
					String nextDate = dfmt.format(dt);
					if (dateOnly.equals(nextDate)) {
						dates.add(timeOnly);
						firstAndLastLoginDates.add(df.parse(empDatestr)+"");
					} else {
						EmpLoginData empLoginData1 = empMap.get(dateOnly);
						empLoginData1.setEmployeeName(empDetails.getEmployeeName());
						empLoginData1.setFirstLogin(Collections.min(firstAndLastLoginDates));
						empLoginData1.setLastLogout(Collections.max(firstAndLastLoginDates));
						String min = dates.get(0);
						String max = dates.get(dates.size()-1);
						SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
						Date maxDate = format.parse(max);
						Date minDate = format.parse(min);
							
						long diffHours = (maxDate.getTime() - minDate.getTime());

						int seconds = ((int) diffHours) / 1000;
						int hours = seconds / 3600;
						int minutes = (seconds % 3600) / 60;
						empLoginData1.setTotalLoginTime(hours + ":" + minutes);
						empMap.put(dateOnly, empLoginData1);

						dates.clear();
						firstAndLastLoginDates.clear();

						empDatestr = empLoginData.getFirstLogin();
						Date Nextdt = df.parse(empDatestr);
						timeOnly = tdf.format(Nextdt);
						dateOnly = dfmt.format(Nextdt);
						dates.add(timeOnly);
						firstAndLastLoginDates.add(df.parse(empDatestr)+"");
						empMap.put(dateOnly, empLoginData);

					}
				}
			}
			System.out.println(" Taking time to do all operation " + (System.currentTimeMillis() - start_ms));

		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		} finally {
			try {
				if (null != connection) {
					resultSet.close();
					statement.close();
					connection.close();
				}
			} catch (SQLException sqlex) {
				sqlex.printStackTrace();
			}
		}

		return new ArrayList<EmpLoginData>(empMap.values());
	}

	private static void getSingleEmploginData(List<EmpLoginData> loginsData, Map<String, List<EmpLoginData>> map,
			EmpLoginData empLoginData) {

		List<EmpLoginData> singleEmpLogindata = new ArrayList<>();

		for (EmpLoginData empLoginData1 : loginsData) {
			if (empLoginData.getUserid().equals(empLoginData1.getUserid())) {
				singleEmpLogindata.add(empLoginData1);
			}
		}
		map.put(empLoginData.getUserid(), singleEmpLogindata);
	}
}