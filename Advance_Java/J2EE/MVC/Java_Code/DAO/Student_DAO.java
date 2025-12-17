package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.StudentDataBean;
import com.mysql.cj.jdbc.MysqlDataSource;

public class Student_DAO {
	
	Connection conn;
	MysqlDataSource ds;
	PreparedStatement prp;
	String qry="insert into student values(?,?)";
	
	
	 public Student_DAO() {
		super();
		// TODO Auto-generated constructor stub
		
	    ds=new MysqlDataSource();
		
		ds.setUser("root");
		ds.setPassword("root");
		ds.setServerName("localhost");
		ds.setDatabaseName("db_j2ee");
		ds.setPort(3306);
	
		try {
			conn=ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	   }
	
		public boolean register_std_data(StudentDataBean bean) {
			int row=0;
			try {
			prp=conn.prepareStatement(qry);
			prp.setInt(1, Integer.parseInt(bean.getStdId()));
			prp.setString(2, bean.getStdName());
			row=prp.executeUpdate();
			if(row>0)
				return true;
			
	
		}catch(SQLException e) {
	       e.printStackTrace();
	     }
      return false;
    }
}


