package com.jdbc;


import java.sql.Connection;
import java.sql.Statement;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DemoJdbcStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn;
		Statement st;
		String qry="insert into customer values(2,'SQL')";
		MysqlDataSource ds;         //class which is used to store db info
		
		try {
			//injecting the info 
			ds=new MysqlDataSource();
			ds.setUser("root");
			ds.setPassword("root");
			ds.setServerName("localhost");
			ds.setDatabaseName("db_j2ee");
			ds.setPort(3306);
			
			//get the connection
			conn=ds.getConnection();
			st=conn.createStatement();
			
			int row=st.executeUpdate(qry);
			if(row>0)
				System.out.println("success");
			else
				System.out.println("fail");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
