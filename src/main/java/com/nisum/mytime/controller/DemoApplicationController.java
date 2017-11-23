/**
 * 
 */
package com.nisum.mytime.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.nisum.mytime.model.EmpLoginData;
import com.nisum.mytime.model.Employee;
import com.nisum.mytime.model.UserAccount;
import com.nisum.mytime.repository.AccountRepository;
import com.nisum.mytime.repository.EmployeeRepository;
import com.nisum.mytime.service.UserService;

/**
 * @author nisum
 *
 */
@RestController
public class DemoApplicationController {

    private static final Logger log = LoggerFactory
            .getLogger(DemoApplicationController.class);

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    AccountRepository repository;
    
    @Autowired
    UserService userService;

//    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
//    public UsernamePasswordAuthenticationToken authenticateUser(
//            @RequestParam("username") String userName,
//            @RequestParam("password") String password) {
//        log.info("action: authenticateUser, User Id: {}", userName);
//        UserAccount account = repository.findByUsernameAndPassword(userName,
//                password);
//        if (account != null) {
//            return new UsernamePasswordAuthenticationToken(userName, password,
//                    account.getRoles());
//        } else {
//            throw new AuthenticationCredentialsNotFoundException(
//                    "Invalid credentails");
//        }
//    }
//
//    @PreAuthorize("hasAuthority('ADMIN_ROLE')")
//    @RequestMapping(value = "/allEmployees", method = RequestMethod.GET,
//            produces = "application/json")
//    public ResponseEntity<List<Employee>> allEmployees() {
//        log.info("action: allEmployees, Fetching all the employees");
//        List<Employee> list = employeeRepository.findAll();
//        if (!list.isEmpty()) {
//            return new ResponseEntity<>(list, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(list, HttpStatus.NO_CONTENT);
//        }
//    }
//
//    @PreAuthorize("hasAnyAuthority('ADMIN_ROLE','USER_ROLE')")
//    @RequestMapping(value = "/getEmployee/{empId}", method = RequestMethod.GET)
//    public ResponseEntity<Employee> getEmployee(
//            @PathVariable("empId") String empId) {
//        log.info("action: getEmployee, Employee Id: {}", empId);
//        Employee employee = employeeRepository.findOne(empId);
//        if (employee == null)
//            return new ResponseEntity<>(employee, HttpStatus.NO_CONTENT);
//        else
//            return new ResponseEntity<>(employee, HttpStatus.OK);
//
//    }
//
//    @PreAuthorize("hasAuthority('ADMIN')")
//    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST,
//            consumes = "application/json")
//    public ResponseEntity<Void> addEmployee(@RequestBody Employee employee,
//            UriComponentsBuilder uri)
//            throws JsonMappingException, JsonParseException, IOException {
//        log.info("action: addEmployee, Employee: {}", employee.toString());
//        employeeRepository.save(employee);
//        HttpHeaders header = new HttpHeaders();
//        header.setLocation(uri.path("/getEmployee/{empId}")
//                .buildAndExpand(employee.getEmpId()).toUri());
//        return new ResponseEntity<>(header, HttpStatus.CREATED);
//    }
//
//    @PreAuthorize("hasAuthority('ADMIN')")
//    @RequestMapping(value = "/updateEmployee", method = RequestMethod.PUT,
//            consumes = "application/json")
//    public ResponseEntity<Employee> updateEmployee(
//            @RequestBody Employee employee, UriComponentsBuilder uri) {
//        log.info("action: updateEmployee, Employee: {}", employee.toString());
//        employeeRepository.save(employee);
//        HttpHeaders header = new HttpHeaders();
//        header.setLocation(uri.path("/getEmployee/{empId}")
//                .buildAndExpand(employee.getEmpId()).toUri());
//        return new ResponseEntity<>(header, HttpStatus.CREATED);
//    }
//
//    @PreAuthorize("hasAuthority('ADMIN')")
//    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.DELETE,
//            consumes = "application/json")
//    public ResponseEntity<Employee> deleteEmployee(
//            @RequestBody Employee employee) {
//        log.info("action: deleteEmployee, Employee: {}", employee.toString());
//        employeeRepository.delete(employee);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @PreAuthorize("hasAnyAuthority('ADMIN_ROLE','USER_ROLE')")
//    @RequestMapping(value = "/getEmployeeByName/{empName}",
//            method = RequestMethod.GET)
//    public ResponseEntity<List<Employee>> getEmployeeByName(
//            @PathVariable("empName") String empName) {
//        List<Employee> list = employeeRepository.findByEmpName(empName);
//        if (!list.isEmpty())
//            return new ResponseEntity<>(list, HttpStatus.OK);
//        else
//            return new ResponseEntity<>(list, HttpStatus.NO_CONTENT);
//
//    }
//
//    @PreAuthorize("hasAnyAuthority('ADMIN_ROLE','USER_ROLE')")
//    @RequestMapping(value = "/getEmployeeByDept/{empDept}",
//            method = RequestMethod.GET)
//    public ResponseEntity<List<Employee>> getEmployeeByDept(
//            @PathVariable("empDept") String empDept) {
//        List<Employee> list = employeeRepository.findByEmpDept(empDept);
//        if (!list.isEmpty())
//            return new ResponseEntity<>(list, HttpStatus.OK);
//        else
//            return new ResponseEntity<>(list, HttpStatus.NO_CONTENT);
//
//    }
//
//    @PreAuthorize("hasAnyAuthority('ADMIN_ROLE','USER_ROLE')")
//    @RequestMapping(value = "/getEmployeeByDesg/{empDesg}",
//            method = RequestMethod.GET)
//    public ResponseEntity<List<Employee>> getEmployeeByDesg(
//            @PathVariable("empDesg") String empDesg) {
//        List<Employee> list = employeeRepository.findByEmpDesg(empDesg);
//        if (!list.isEmpty())
//            return new ResponseEntity<>(list, HttpStatus.OK);
//        else
//            return new ResponseEntity<>(list, HttpStatus.NO_CONTENT);
//
//    }
//
//    @PreAuthorize("hasAnyAuthority('ADMIN_ROLE','USER_ROLE')")
//    @RequestMapping(value = "/getEmployeeByNameAndDept/{empName}/{empDept}",
//            method = RequestMethod.GET)
//    public ResponseEntity<List<Employee>> getEmployeeByNameAndDept(
//            @PathVariable("empName") String empName,
//            @PathVariable("empDept") String empDept) {
//        List<Employee> list = employeeRepository
//                .findByEmpNameAndEmpDept(empName, empDept);
//        if (!list.isEmpty())
//            return new ResponseEntity<>(list, HttpStatus.OK);
//        else
//            return new ResponseEntity<>(list, HttpStatus.NO_CONTENT);
//    }
//
//    @PreAuthorize("hasAnyAuthority('ADMIN_ROLE','USER_ROLE')")
//    @RequestMapping(value = "/getEmployeeByDeptAndDesg/{empDept}/{empDesg}",
//            method = RequestMethod.GET)
//    public ResponseEntity<List<Employee>> getEmployeeByTypeAndDesg(
//            @PathVariable("empDept") String empDept,
//            @PathVariable("empDesg") String empDesg) {
//        List<Employee> list = employeeRepository
//                .findByEmpDeptAndEmpDesg(empDept, empDesg);
//        if (!list.isEmpty())
//            return new ResponseEntity<>(list, HttpStatus.OK);
//        else
//            return new ResponseEntity<>(list, HttpStatus.NO_CONTENT);
//
//    }
//
//    // @PreAuthorize("hasAnyAuthority('ADMIN_ROLE','USER_ROLE')")
//    // @RequestMapping(value = "/sendSimpleMail", method = RequestMethod.POST)
//    // public ResponseEntity<String> sendSimpleMail() {
//    // String response = mailService.sendSimpleEmail();
//    // if (response.equals("S"))
//    // return new ResponseEntity<String>("Mail sent successfully",
//    // HttpStatus.OK);
//    // else
//    // return new ResponseEntity<String>(response,
//    // HttpStatus.INTERNAL_SERVER_ERROR);
//    // }
//    //
//    // @PreAuthorize("hasAuthority('ADMIN_ROLE')")
//    // @RequestMapping(value = "/sendAttachmentMail", method =
//    // RequestMethod.POST)
//    // public ResponseEntity<String> sendAttachmentMail(
//    // @RequestParam("path") String path) {
//    // String response = mailService.sendEmailWithAttachment(path);
//    // if (response.equals("S"))
//    // return new ResponseEntity<String>("Mail sent successfully",
//    // HttpStatus.OK);
//    // else
//    // return new ResponseEntity<String>(response,
//    // HttpStatus.INTERNAL_SERVER_ERROR);
//    // }
    
    @RequestMapping(value = "employee/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmpLoginData>> fetchEmployeeDataBasedOnEmpId(@PathVariable("id") long id)
			throws FileNotFoundException, ParseException {
		List<EmpLoginData> empLoginData = userService.fetchEmployeeDataBasedOnEmpId(id);
		return new ResponseEntity<List<EmpLoginData>>(empLoginData, HttpStatus.OK);
	}
}
