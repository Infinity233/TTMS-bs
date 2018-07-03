package com.Infinity.service;

import com.Infinity.dao.EmployeeMapper;
import com.Infinity.pojo.Employee;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.web.servlet.ModelAndView;

@Service
public class EmployeeService {

    private EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeService (EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    // 查找 不存在的话插入一条记录并返回新的主键
    public int getEmployeePrimaryKey(String name) {
        Integer id = employeeMapper.selectByname(name);

        if (id == null) {

            Employee employee = new Employee(name);

            employeeMapper.insert(employee);
            id = employee.getId();
        }
        return id;
    }

}
