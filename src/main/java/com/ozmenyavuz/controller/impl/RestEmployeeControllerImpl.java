package com.ozmenyavuz.controller.impl;

import com.ozmenyavuz.controller.RestEmployeeController;
import com.ozmenyavuz.dto.DtoEmployee;
import com.ozmenyavuz.model.RootEntity;
import com.ozmenyavuz.service.IEmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/employee")
public class RestEmployeeControllerImpl extends RestBaseController implements RestEmployeeController {

    private final IEmployeeService employeeService;
    public RestEmployeeControllerImpl(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list/{id}")
    @Override
    public RootEntity<DtoEmployee> findEmployee(@PathVariable(value = "id") Long id) {
        return ok(employeeService.findEmployee(id));
    }
}
