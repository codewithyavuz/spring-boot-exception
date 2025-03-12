package com.ozmenyavuz.service.impl;


import com.ozmenyavuz.dto.DtoDepartment;
import com.ozmenyavuz.dto.DtoEmployee;
import com.ozmenyavuz.exception.BaseException;
import com.ozmenyavuz.exception.ErrorMessage;
import com.ozmenyavuz.exception.MessageType;
import com.ozmenyavuz.model.Department;
import com.ozmenyavuz.model.Employee;
import com.ozmenyavuz.repository.EmployeeRepository;
import com.ozmenyavuz.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private final EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public DtoEmployee findEmployee(Long id) {

        // 1. DTO nesnelerini oluştur
        DtoEmployee dtoEmployee = new DtoEmployee();
        DtoDepartment dtoDepartment = new DtoDepartment();


        // 2. Optional kontrolünü düzelt
        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString()));
        }
        Employee employee = optional.get();
        Department department = employee.getDepartment();

        // 3. Verileri DTO'lara kopyala
        BeanUtils.copyProperties(employee, dtoEmployee);
        BeanUtils.copyProperties(department, dtoDepartment);

        // 4. DTO'ları bağla
        dtoEmployee.setDtoDepartment(dtoDepartment);

        return dtoEmployee;
    }
}
