package com.bridegelabz.employeepayrollapp.respository;

import com.bridegelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeePayrollRespository extends JpaRepository<EmployeePayrollData, Integer>
{
    @Query(value = "select * from employee_payroll,employee_department where employee_id = id and department = :department",nativeQuery = true)
    List<EmployeePayrollData> findEmployeesByDepartment(String department);
}
