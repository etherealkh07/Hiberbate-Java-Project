package com.EntityPackage.Services;

import java.util.Iterator;
import java.util.Scanner;

import org.hibernate.internal.build.AllowSysOut;

import com.EntityPackage.Company;
import com.EntityPackage.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Service {

    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("aakash");
    public static Scanner scn = new Scanner(System.in);

    public static void save() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        System.out.println("What do you want to save?");
        System.out.println("1. Company");
        System.out.println("2. Employee");
        System.out.print("Enter the number: ");
        int n = scn.nextInt();
        scn.nextLine();

        if (n == 1) {
            System.out.println("Enter the Company Name:");
            String cname = scn.nextLine();
            System.out.println("Enter the Location:");
            String loc = scn.nextLine();

            Company company = new Company();
            company.setCname(cname);
            company.setLoc(loc);

            et.begin();
            em.persist(company);
            et.commit();
        } else if (n == 2) {
            System.out.println("Enter the Employee Name:");
            String ename = scn.nextLine();
            System.out.println("Enter the Salary:");
            int salary = scn.nextInt();
            scn.nextLine(); 
            System.out.println("Enter the Company ID:");
            int companyId = scn.nextInt();

            Company company = em.find(Company.class, companyId);
            if (company != null) {
                Employee emp = new Employee();
                emp.setEname(ename);
                emp.setSal(salary);
                emp.setComp(company);

                et.begin();
                em.persist(emp);
                et.commit();
            } else {
                System.out.println("Company with ID " + companyId + " not found.");
            }
        }

        System.out.println("Data saved!");
    }
    
    
    public static void update() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        System.out.println("Press 1 to update Company details");
        System.out.println("Press 2 to update Employee details");
        System.out.print("Select which details you need to update: ");
        int n = scn.nextInt();
        scn.nextLine(); 
        
        if (n == 1) {
            System.out.println("Enter the Company ID to update:");
            int companyId = scn.nextInt();
            scn.nextLine();

            Company company = em.find(Company.class, companyId); 
            if (company != null) {
                System.out.println("Press 1 to update Company Name");
                System.out.println("Press 2 to update Company Location");
                int x = scn.nextInt();
                scn.nextLine();

                et.begin();
                if (x == 1) { 
                    System.out.println("Enter the new Company Name:");
                    String cname = scn.nextLine();
                    company.setCname(cname);
                } else if (x == 2) {
                    System.out.println("Enter the new Company Location:");
                    String cloc = scn.nextLine();
                    company.setLoc(cloc);
                }
                em.merge(company); 
                et.commit();
                System.out.println("Company details updated successfully!");
            } else {
                System.out.println("Company with ID " + companyId + " not found.");
            }
        } else if (n == 2) { 
            System.out.println("Enter the Employee ID to update:");
            int employeeId = scn.nextInt();
            scn.nextLine();

            Employee employee = em.find(Employee.class, employeeId); // Fetch existing employee
            if (employee != null) {
                System.out.println("Press 1 to update Employee Name");
                System.out.println("Press 2 to update Employee Salary");
                int x = scn.nextInt();
                scn.nextLine();

                et.begin();
                if (x == 1) { 
                    System.out.println("Enter the new Employee Name:");
                    String ename = scn.nextLine();
                    employee.setEname(ename);
                } else if (x == 2) { 
                    System.out.println("Enter the new Employee Salary:");
                    int salary = scn.nextInt();
                    employee.setSal(salary);
                }
                em.merge(employee); 
                et.commit();
                System.out.println("Employee details updated successfully!");
            } else {
                System.out.println("Employee with ID " + employeeId + " not found.");
            }
        } else {
            System.out.println("Invalid option.");
        }

        em.close();
        System.out.println("Details are updated!!!!!");
    }

    
    public static void fetch()
    {
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction et = em.getTransaction();
    	
    	System.out.println("Which details you need to fetch ");
    	System.out.println("Press 1 for Company details");
    	System.out.println("press 2 for Employee details");
    	System.out.println("Enter your number:");
    	int n = scn.nextInt();
    	scn.nextLine();
    	
    	if(n==1)
    	{
    		System.out.println("Enter Company Id to fetch:");
    		int id = scn.nextInt();
    		scn.nextLine();
    		
    		Company comp = em.find(Company.class, id);
    		if(comp != null)
    		{
    			System.out.println("---The Company Details---");
    			System.out.println("The Company Id : "+ comp.getCid());
    			System.out.println("The Company Name : "+ comp.getCname());
    			System.out.println("The Company Location : "+ comp.getLoc());
    		}
    		else
    		{
    			System.out.println(id+ " This Id is Not Found, Check your Id");
    			
    		}
    	}else if(n==2) {
    		System.out.println("Enter Employee id to fetch:");
    		int eid = scn.nextInt();
    		scn.nextInt();
    		
    		Employee emp = em.find(Employee.class, eid);
    		if(emp != null)
    		{
    			System.out.println("Details of the Employee:");
    			System.out.println("Employee Id: "+ emp.getEid());
    			System.out.println("Employee Name: "+ emp.getEname());
    			System.out.println("Employee Salary: "+ emp.getSal());
    			System.out.println("Employee Company: "+ emp.getComp().getCname());
    			
    		}
    		else {
    			System.out.println(eid + " Invalid EMployee Id");
    		}
    		
    		
    	}
    	
    	et.begin();
    	et.commit();
    }
    
    public static void delete()
    {
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction et = em.getTransaction();
    	
    	System.out.println("Which details you Need to delete  ");
    	System.out.println("Press 1 for Company details");
    	System.out.println("press 2 for Employee details");
    	System.out.println("Enter your number:");
    	int n = scn.nextInt();
    	scn.nextLine();
    	
    	if(n == 1)
    	{
    		System.out.println("Enter the Company details to delete ");
    		System.out.println("Enter the Company Id  to delete: ");
    		int cid = scn.nextInt();
    		
    		Company comp = em.find(Company.class, cid);
    		if(comp != null)
    		{
    			et.begin();
    			
    			for(Employee emp: comp.getEmp())
    			{
    				em.remove(emp);
    			}
    			em.remove(comp);
    			et.commit();
    			System.out.println(cid +" is deleted from database");
    		}else {
    			System.out.println(cid + " Invalid id");
    		}
    		
    	}else
    	{
    		System.out.println("Enter the Employee details to delete ");
    		System.out.println("Enter the Employee Id  to delete: ");
    		int eid = scn.nextInt();
    		
    		Employee emp = em.find(Employee.class, eid);
    		if(emp != null)
    		{
    			et.begin();
    			em.remove(emp);
    			et.commit();
    			System.out.println(eid +" is deleted from database");
    		}else {
    			System.out.println(eid + " Invalid id");
    		}
    	}
    	em.close();
    }

}
