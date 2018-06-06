package com.Infinity.test;

import com.Infinity.dao.EmployeeMapper;
import com.Infinity.pojo.Employee;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/em")
public class EmployeeTest{

    Logger log = Logger.getLogger(EmployeeTest.class);

    @Autowired
    EmployeeMapper employeeMapper;

    @RequestMapping("/selectall")
    public String selectall() {

        List<Employee> list = employeeMapper.selectAll();

        System.out.println(list);

        return "welcome";
    }

    @RequestMapping("/selectById")
    public String selectById(int id) {

        Employee employee = employeeMapper.selectByPrimaryKey(id);
        System.out.println(employee);

        return "welcome";
    }
}