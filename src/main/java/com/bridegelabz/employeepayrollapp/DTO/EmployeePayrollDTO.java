package com.bridegelabz.employeepayrollapp.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

public @ToString class EmployeePayrollDTO
{
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$" , message = " Employee Name is Invalid")
    public String name;

   @Min(value = 500 , message = "Min Wage should be 500")
    public long salary;

   public String gender;
   @JsonFormat(pattern = "dd MMM yyyy")
   public LocalDate startDate;
   public String note;
   public String profilePic;
   public List<String> departments;
}
