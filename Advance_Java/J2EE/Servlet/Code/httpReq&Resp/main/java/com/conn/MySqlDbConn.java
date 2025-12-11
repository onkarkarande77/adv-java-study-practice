package com.conn;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

public class MySqlDbConn {
	Connection conn;
    MysqlDataSource ds;
    
    public MySqlDbConn() {
    	ds=new MysqlDataSource();
    	
    	ds.setUser("root");
    	ds.setPassword("pass@123");
    	ds.setServerName("localhost");
    	ds.setDatabaseName("revise");
    	ds.setPort(3306);
    }
    
    public Connection getConn() {
    	try {
			conn=ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return conn;
    }
}
