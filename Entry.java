package com;



import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Entry
{
	static String uname;
	
	static Configuration cfg ;
	static SessionFactory factory;
	static Session s;
	public Entry()
	{
		
	}
	public static void main(String[] args)
	{
			System.out.println("Table Per Hirarchy Example.");
			Scanner sc  =  new Scanner(System.in);
			
			
			System.out.println("Add for Faculty Information ");
			
			Teacher teacher = new Teacher();
			System.out.println("Enter College Name :");
			teacher.setCol_Name(sc.nextLine());
			System.out.println("Enter Faculty Name :");
			uname  = sc.nextLine();
			teacher.setFaculty_Name(uname);
			
		 
		System.out.println("Enter student Information");
			Student stud = new Student();			
			System.out.println("Enter College Name :");
			stud.setCol_Name(sc.nextLine());
			System.out.println("Enter Student Name :");
			stud.setStud_Name(sc.nextLine());
		
			cfg= new Configuration();
			cfg.configure("hibernate.cfg.xml");
			factory = cfg.buildSessionFactory();
			s= factory.openSession();
			Transaction t =		s.beginTransaction();    
		  try
	         {
	        	 s.save(teacher);
	        	 s.save(stud);	
	         }
	         catch(Exception e)
	         {
	        	 System.out.println("Save Error "+e.toString());
	         }
	         s.getTransaction().commit();
	        	// t.commit();
	         System.out.println("Command successfully executed....");
		     s.close();
	         factory.close();
	         }
	
	
}
