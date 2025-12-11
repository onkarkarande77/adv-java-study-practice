package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.mysql.cj.jdbc.MysqlDataSource;

public class PS_Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection conn;
		PreparedStatement prp;
		MysqlDataSource ds;
		String qry="insert into cust_detail values(?,?)";
		//String id;
		//String name;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter id");
		 int id=sc.nextInt();
		 System.out.println("enter name");
		 String name=sc.next();
		
		
		try {
			ds=new MysqlDataSource();
			ds.setUser("root");
			ds.setPassword("root");
			ds.setDatabaseName("db_j2ee");
			ds.setServerName("localhost");
			ds.setPort(3306);
			
			conn=ds.getConnection();
			prp=conn.prepareStatement(qry);
			
			prp.setInt(1, id);
			prp.setString(2,name);
			
			//prp.
			
			prp.executeUpdate();
			/*if(row>0)
				System.out.println("success");
			else
				System.out.println("fail");*/
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
