package com.jsprider.project.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsprider.project.entity.Employee;
import javax.persistence.Query;

@Component(value = "dao")
public class EmployeeDao {
	@Autowired
	private EntityManager entityManager;
	
	public void saveEmployee(Employee employee) {
		
		// EntityManager entityManager=EntityManagerFactory.createEntityManager();
		
		 EntityTransaction entityTransaction=entityManager.getTransaction();
		
		
		entityTransaction.begin();
		
		entityManager.persist(employee);
		
		entityTransaction.commit();
		System.out.println("employee saved");
		
	}
	public Employee getEmployee(int id) {
		
		String query="select e from Employee e where e.id=?1";
		Query q=entityManager.createQuery(query);
		q.setParameter(1, id);
		return (Employee) q.getSingleResult();
		
		
	}
	public void updateEmployee(int id, Employee newEmployee) {
		try {
		Employee e=getEmployee(id);
		EntityTransaction tran=entityManager.getTransaction();
		tran.begin();
	     newEmployee.setId(id);
	     entityManager.merge(newEmployee);
		tran.commit();
		System.out.println("deleted");
		}catch(NoResultException e) {
			System.out.println("Id not Found");
		}
	}
		
		
    public void removeEmployee(int id) {
    	try {
    		Employee e=getEmployee(id);
    		EntityTransaction tran=entityManager.getTransaction();
    		tran.begin();
    		entityManager.remove(e);
    		tran.commit();
    		System.out.println("employee removed");
    	}catch(NoResultException e) {
    		System.out.println("id not Found");
    	}
    	
    }
       public List <Employee> getAllEmployee(){
    	 
    		   String query="select e from Employee e";
    		   Query q=entityManager.createQuery(query);
    		  List<Employee>list= q.getResultList();
    		  return list;
    		  
    		  
    	   
		
	}
}
	


