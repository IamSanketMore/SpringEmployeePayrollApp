package com.bridegelabz.employeepayrollapp.exceptions;

import com.bridegelabz.employeepayrollapp.DTO.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class EmployeePayrollExceptionHandlers
{
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseDTO> httpMessageNotReadableException(HttpMessageNotReadableException exception) {
        log.error("Invalid date format", exception);
        ResponseDTO responseDTO = new ResponseDTO("Exception While processing  REST  REquest", "Should have date format dd MMM yyyy");
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(
    MethodArgumentNotValidException exception){
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errMsg = errorList.stream().map(objectError -> objectError.getDefaultMessage()).collect(Collectors.toList());

        ResponseDTO responseDTO = new ResponseDTO("Exception While processing  REST  REquest",errMsg);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmployeeePayrollException.class)
    public ResponseEntity<ResponseDTO> handleEmployeeePayrollException(EmployeeePayrollException exception)
    {
        ResponseDTO responseDTO = new ResponseDTO("Exception While processing  REST  REquest",exception.getMessage());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
