package com.nisum.mytime.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nisum.mytime.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
	public List<Employee> findByEmpName(String empName);
	public List<Employee> findByEmpDesg(String empDesg);
	public List<Employee> findByEmpDept(String empDept);
	public List<Employee> findByEmpNameAndEmpDept(String empName, String empDept);
	public List<Employee> findByEmpDeptAndEmpDesg(String empDept, String empDesg);
}
