package com.jsprider.project;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.jsprider.project.config.EmployeeConfig;
import com.jsprider.project.dao.EmployeeDao;
import com.jsprider.project.entity.Employee;
public class A {
	@Autowired
	private EntityManagerFactory emf;
	
	public static void main(String[] args) {
		
		ApplicationContext ac=new AnnotationConfigApplicationContext(EmployeeConfig.class);
		EmployeeDao dao=ac.getBean("dao",EmployeeDao.class);
		Employee e=new Employee();
		e.setName("ram");
		e.setEmail("vaibahv@123");
		e.setSalary(1100.0);
		e.setPassword("helo");
		e.setPhone(435);
		e.setExperience(1);
		
//		List<Employee>list= dao.getAllEmployee();
//		for (Employee employee : list) {
//			System.out.println(employee);
//		}
//		dao.updateEmployee(1,e);
//		dao.removeEmployee(2);
		dao.saveEmployee(e);
		
//		Employee emp=dao.getEmployee(1);
//		System.out.println(emp.getName());
		
		
	}

}
