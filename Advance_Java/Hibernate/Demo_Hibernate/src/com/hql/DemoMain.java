package com.hql;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;



public class DemoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		//write an HQL query to retrive all objects  from the table
		Query q1=s.createQuery("from Disc");
		//System.out.println(q1.list());
		List<Disc> d=q1.list();
		for(Disc di:d)
			System.out.println(di);
		
		//write sql query to fetch the average price of all disc objects
		Query q2=s.createQuery("select avg(disc_price) from Disc");
		System.out.println(q2.uniqueResult());
		
		//write HQL query to fetch the avg price of audio and video
		Query q3=s.createQuery("select avg(disc_price) from Disc group by disc_type");
		System.out.println(q3.list());
		
		//
		Transaction tx=s.beginTransaction();
	   
		Query q4=s.createQuery("update Disc set disc_price=disc_price+100 where disc_type='video'");
		System.out.println(q4.executeUpdate());
		tx.commit();

	}

}
