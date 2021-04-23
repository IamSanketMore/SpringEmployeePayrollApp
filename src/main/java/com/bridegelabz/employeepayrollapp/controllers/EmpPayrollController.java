package com.bridegelabz.employeepayrollapp.controllers;

import com.bridegelabz.employeepayrollapp.DTO.EmployeePayrollDTO;
import com.bridegelabz.employeepayrollapp.DTO.ResponseDTO;
import com.bridegelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridegelabz.employeepayrollapp.services.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeePayrollService")
public class EmpPayrollController
{
    @Autowired
    private IEmployeePayrollService employeePayrollService;
    //http://localhost:8080/employeePayrollService
    //http://localhost:8080/employeePayrollService/
    //http://localhost:8080/employeePayrollService/get
    @RequestMapping(value = { "", "/", "get" })
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        List<EmployeePayrollData> empDataList = null;
        empDataList =  employeePayrollService.getEmployeePayrollData();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Successful", empDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //http://localhost:8080/employeePayrollService/get/1
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId)
    {
        EmployeePayrollData empData = null;
        empData = employeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call For Id Successful", empData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //curl  -X POST -H "Content-Type:application/json" -d "{\"name\": \"Sanket More\",\"salary\":200000 }" http://localhost:8080/employeePayrollService/create
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData( @RequestBody EmployeePayrollDTO employeePayrollDTO)
    {
        EmployeePayrollData empData = null;
        empData = employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Create Employee Payroll Data Successfully", empData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //curl  -X PUT -H "Content-Type:application/json" -d "{\"name\": \"Sanket More\",\"salary\":300000 }" http://localhost:8080/employeePayrollService/update
    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData( @PathVariable("empId") int empId,@RequestBody EmployeePayrollDTO employeePayrollDTO)
    {
        EmployeePayrollData empData = null;
        empData = employeePayrollService.updateEmployeePayrollData(empId,employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Update Employee Payroll Data Successfully", empData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //curl  -X DELETE -H "Content-Type:application/json" -d "{\"name\": \"Sanket More\",\"salary\":300000 }" http://localhost:8080/employeePayrollService/delete/1
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData( @PathVariable("empId") int empId)
    {
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully","Deleted Id:-" +empId);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }



}
