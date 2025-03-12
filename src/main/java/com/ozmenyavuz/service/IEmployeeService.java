package com.ozmenyavuz.service;


import com.ozmenyavuz.dto.DtoEmployee;
import com.ozmenyavuz.model.Employee;
import org.springframework.stereotype.Service;


public interface IEmployeeService {
    public DtoEmployee findEmployee(Long id);
}
