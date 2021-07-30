package com.ems.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ems.dao.EmployeeDao;


public class App 
{
    public static void main( String[] args )
    {
    	EmployeeDao empdao=new EmployeeDao();
    	int c=0;
    	while(c!=5) {
       System.out.println("     Empolyee Management System");
       System.out.println(
       		"    1.New Employee\n"+ 
       		"    2.Edit Employee\r\n" + 
       		"    3.Delete Employee\r\n" + 
       		"    4.View All Employees\r\n" + 
       		"    5.Exit ( Enter Your choice ):");
            Scanner sc=new Scanner(System.in);
            c=sc.nextInt();
            Employee e=null;
            int empid=0;
            String name="";
            int age=0;
            String city="";
            
            switch(c) {
            case 1: System.out.println("Enter Employee id,name,age,city");
                     empid=sc.nextInt();
                     name=sc.next();
                     age=sc.nextInt();
                     city=sc.next();
                     e=new Employee(empid, name, age, city);
                      empdao.newEmployee(e);
            	break;
            	
            case 2:  System.out.println("Enetr the id of employee you want to edit");
                     empid=sc.nextInt();
            	     e=empdao.getEmployee(empid);
            	     if(e==null) {
            	    	 System.out.println("Invalid Id Entered!!!! Please Check Again4");
            	    	 break;
            	     }
            	     else {
            	     System.out.println(e.toString());
            	     System.out.println("enter the values you want to edit in order Name Age City");
            	     name=sc.next();
                     age=sc.nextInt();
                     city=sc.next();
            	     empdao.updateEmployee(e);
            	     }
            	break;
            case 3:
            	    System.out.println("Enetr the id of employee you want to delete");
            	    empid=sc.nextInt();
            	    empdao.deleteEmployee(empid);
            	     
            	break;
            case 4:
            	     List<Employee> fl= empdao.getAllEmployees();
            	     for(Employee x:fl)
            	    	 System.out.println(x.toString());
            	break;
            case 5:
            	     empdao.close();
            	     System.out.println("Thank You");
            	break;
            }
    	}
    }
}
