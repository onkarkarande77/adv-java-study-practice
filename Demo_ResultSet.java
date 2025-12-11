package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

public class Demo_ResultSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn;
		PreparedStatement prp;
		ResultSet rs;
		String qry="select * from cust_detail";
		MysqlDataSource ds;
		
		try {
			   ds = new MysqlDataSource();

	            ds.setUser("root");
	            ds.setPassword("root");
	            ds.setServerName("localhost");
	            ds.setDatabaseName("db_j2ee");
	            ds.setPort(3306);

	            conn = ds.getConnection();

	            prp = conn.prepareStatement(qry);
	            rs = prp.executeQuery();
	            
	            while(rs.next()) {
	            
	            rs.getInt(1);
	            rs.getString(2);
	            }
	            /*while (rs.next()) {
	                System.out.println("id is " + rs.getInt(1));
	                System.out.println("name is " + rs.getString(2));
			}*/
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
