package com.bridegelabz.employeepayrollapp.respository;

import com.bridegelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePayrollRespository extends JpaRepository<EmployeePayrollData, Integer>
{
    
}
