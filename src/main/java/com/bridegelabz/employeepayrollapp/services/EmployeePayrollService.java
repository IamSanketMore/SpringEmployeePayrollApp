package com.bridegelabz.employeepayrollapp.services;

import com.bridegelabz.employeepayrollapp.DTO.EmployeePayrollDTO;
import com.bridegelabz.employeepayrollapp.DTO.ResponseDTO;
import com.bridegelabz.employeepayrollapp.exceptions.EmployeeePayrollException;
import com.bridegelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridegelabz.employeepayrollapp.respository.EmployeePayrollRespository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
    private EmployeePayrollRespository employeePayrollRespository;

    private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollRespository.findAll();
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrollRespository.findById(empId).orElseThrow( () ->
                new EmployeeePayrollException("Employee With EmployeeID " +
                        empId +"does not exists"));
    }

    @Override
    public List<EmployeePayrollData> getEmployeesByDepartment(String department) {
       return  employeePayrollRespository.findEmployeesByDepartment(department);
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData( employeePayrollDTO);
        //employeePayrollList.add(empData);
        log.debug("Emp Data: " +empData.toString());
        return employeePayrollRespository.save(empData);
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        empData.updateEmployeePayrollData(employeePayrollDTO);
        return employeePayrollRespository.save(empData);
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        EmployeePayrollData empData =this.getEmployeePayrollDataById(empId);
        employeePayrollRespository.delete(empData);

    }


}