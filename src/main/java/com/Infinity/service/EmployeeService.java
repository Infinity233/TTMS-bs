package com.Infinity.service;

import com.Infinity.dao.EmployeeMapper;
import com.Infinity.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

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
