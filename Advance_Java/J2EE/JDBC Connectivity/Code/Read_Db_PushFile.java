package com.jdbc;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;


public class Read_Db_PushFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn;
		PreparedStatement prp;
		String qry="select * from cust_detail";
		ResultSet rs;
		MysqlDataSource ds;
		FileWriter fw=null;
		BufferedReader br;
		InputStreamReader isr;
		
		try {
			
			fw=new FileWriter("ps.txt",true);
			//br=new BufferedReader(new InputStreamReader(System.in));
			
			
			
			
			
			ds=new MysqlDataSource();
			
			ds.setUser("root");
			ds.setPassword("root");
			ds.setServerName("localhost");
			ds.setDatabaseName("db_j2ee");
			ds.setPort(3306);
			
			conn=ds.getConnection();
			prp=conn.prepareStatement(qry);
			
			rs=prp.executeQuery();
			
			System.out.println("id"+" "+"name");
			
			while(rs.next())
			{
				String id=String.valueOf(rs.getInt(1));
				String name=rs.getString(2);
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
				//System.out.println(rs.getString(2));
				
				fw.write(id);
				fw.write("#");
				fw.write(name);
				fw.write("\n");
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}finally {
			try {
				fw.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		

	}

}
