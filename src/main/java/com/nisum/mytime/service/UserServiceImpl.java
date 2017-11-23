package com.nisum.mytime.service;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nisum.mytime.model.EmpLoginData;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Override
	public List<EmpLoginData> fetchEmployeeDataBasedOnEmpId(long id) throws FileNotFoundException, ParseException {
		return MsAccessDatabaseConnectionInJava8.fetchEmployeeDataBasedOnEmpId(id);
	}

}
