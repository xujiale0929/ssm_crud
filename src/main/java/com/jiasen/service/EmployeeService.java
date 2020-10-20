package com.jiasen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiasen.bean.Employee;
import com.jiasen.dao.EmployeeMapper;

@Service
public class EmployeeService {

	@Autowired
	EmployeeMapper employeeMapper;

	public List<Employee> getAll() {
		List<Employee> selectByExampleWithDept = employeeMapper.selectByExampleWithDept(null);
		return selectByExampleWithDept;
	}

}
