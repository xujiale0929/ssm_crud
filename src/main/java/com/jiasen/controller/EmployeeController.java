package com.jiasen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jiasen.bean.Employee;
import com.jiasen.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/getall")
	public String getAll(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		// 分页
		List<Employee> list = employeeService.getAll();
		System.out.println(list.get(0).geteName());
		return "list";
	}

}
