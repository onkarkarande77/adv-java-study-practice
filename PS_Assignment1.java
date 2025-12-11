package com.jdbc; 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;

import com.mysql.cj.jdbc.MysqlDataSource;

import com.mysql.cj.xdevapi.Result;

public class PS_Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method 
		Connection conn;
		PreparedStatement prp;
        String qry="insert into data values(?,?)";
        MysqlDataSource ds;
        FileReader fr;
        BufferedReader  br;
        StringTokenizer st;
       // String data;
        
        
        try {
        	String data=" ";
        	//fr=new FileReader("ps.txt");
        	//st=new StringTokenizer(data,"#");
           ds=new MysqlDataSource();
        	
        	ds.setUser("root");
        	ds.setPassword("root");
        	ds.setServerName("localhost");
        	ds.setDatabaseName("db_j2ee");
        	ds.setPort(3306);
        	
        	conn=ds.getConnection();
        	prp=conn.prepareStatement(qry);
        	
        	br=new BufferedReader(new FileReader("ps.txt"));
        	
        	System.out.println("id"+" "+"name");
        	System.out.println(" ");
        	
        	data=br.readLine();
        	while(data!=null)
        		
        	{
        		st=new StringTokenizer(data,"#");
        		
        		while(st.hasMoreTokens())
        		{
        			String id=st.nextToken();
        			String name=st.nextToken();
        			//String email=st.nextToken();
        			System.out.println(id+" "+name);
        			//System.out.println(name);
        			//System.out.println(email);
        			
        			prp.setInt(1,Integer.parseInt(id));
        			prp.setString(2,name);
        			
        			prp.executeUpdate();
        		}
        		data=br.readLine();
        		//System.out.println(id);
        	}
        		//System.out.println(id);
        		
        		
        		   
        	}catch(Exception e) {
                e.printStackTrace();	
            }
        	
        
        	
        	//data=br.readLine();
        
       
            }
       
	}


