package com.lti.JdbcDemo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
	Connection con;
	Statement st;
	ResultSet rs;
	
	public App(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","abc12345");
		 st=con.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void getAccountDetails(){
		try{
			rs=st.executeQuery("select * from clients");
			while(rs.next()){
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
