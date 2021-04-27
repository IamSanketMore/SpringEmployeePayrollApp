package com.bridegelabz.employeepayrollapp.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

public @ToString class EmployeePayrollDTO
{
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$" , message = " Employee Name is Invalid")
    public String name;

   @Min(value = 500 , message = "Min Wage should be 500")
    public long salary;

   @Pattern(regexp = "male|female" ,message = "Gender needs to be male and female")
   public String gender;

   @JsonFormat(pattern = "dd MMM yyyy")
   @NotNull(message = "StartDate should Not be Empty")
   @PastOrPresent(message = "StartDate should be past or todays date")
   public LocalDate startDate;

   @NotBlank(message = "Note Cannot be empty")
   public String note;

    @NotBlank(message = "ProfilePic Cannot be empty")
   public String profilePic;

    @NotNull(message = "Departments Should Not be empty")
   public List<String> departments;
}
