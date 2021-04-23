package com.bridegelabz.employeepayrollapp.services;

import com.bridegelabz.employeepayrollapp.DTO.EmployeePayrollDTO;
import com.bridegelabz.employeepayrollapp.model.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {

    List<EmployeePayrollData> getEmployeePayrollData();

    EmployeePayrollData getEmployeePayrollDataById(int empId);

    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);

    EmployeePayrollData updateEmployeePayrollData(int empID,EmployeePayrollDTO employeePayrollDTO);

    void deleteEmployeePayrollData(int empId);

}