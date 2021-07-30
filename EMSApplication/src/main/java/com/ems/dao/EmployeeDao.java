package com.ems.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ems.model.Employee;


public class EmployeeDao {
 
	Configuration cfg=new Configuration();
    SessionFactory sFac=cfg.addAnnotatedClass(Employee.class).configure().buildSessionFactory();
    Session s=sFac.openSession();
    Transaction tx=s.beginTransaction();
	public void newEmployee(Employee e) {
		s.save(e);
		tx.commit();
//		s.close();
//	    sFac.close();
	    System.out.println("DataSaved......"); 
	}
	
	public Employee getEmployee(int empno) {
		Employee e=new Employee();
		e=s.get(Employee.class, empno);
		
		return e;
	}
	public List<Employee> getAllEmployees(){
		
		List<Employee> ls=s.createQuery("from Employee").list();
		return ls;
	}
	
	public void updateEmployee(Employee e) {
		s.update(e);
		tx.commit();
		 System.out.println("DataUpdated......");
	}
	public void deleteEmployee(int empno) {
		Employee es=new Employee();
		es=getEmployee(empno);
		s.delete(es);
		tx.commit();
		System.out.println("DataDeleted.......");
		
	}
	public void close() {
//		tx.commit();
		s.close();
		sFac.close();
	}

	
}
