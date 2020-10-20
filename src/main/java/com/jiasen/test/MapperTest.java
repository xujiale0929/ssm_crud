package com.jiasen.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jiasen.bean.Employee;
import com.jiasen.dao.DepartmentMapper;
import com.jiasen.dao.EmployeeMapper;

/**
 * 
 * @author xujiale
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class MapperTest {

	@Autowired
	EmployeeMapper employeeMapper;

	@Autowired
	DepartmentMapper departmentMapper;

	@Autowired
	SqlSession session;

	@Test
	public void test() {
		/**
		 * // 1.创建SpringIoc容器 // 2.从容器中或获取mapper
		 */
//		ApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//		DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);
//		System.out.println(bean);

		System.out.println(departmentMapper);
		// 1.插入几个部门
//		departmentMapper.insertSelective(new Department(null, "开发部"));
//		departmentMapper.insertSelective(new Department(null, "产品部"));
//		departmentMapper.insertSelective(new Department(null, "研发部"));

		// 2.生成员工数据
//		employeeMapper.insertSelective(new Employee(null, "xujiale", "245987430@qq.com", "M", 1));

		// 3.批量添加员工
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		for (int i = 0; i < 1000; i++) {
			String uid = UUID.randomUUID().toString().substring(0, 5);
			mapper.insertSelective(new Employee(null, uid, uid + "@qq.com", "M", 1));
		}
		System.out.println("批量插入完成。。。。。。。。");

	}

}
