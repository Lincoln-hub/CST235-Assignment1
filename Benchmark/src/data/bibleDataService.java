package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ejb.Local;
//import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class bibleDataService
 */
@Stateless
@Local(dataAccessInterface.class)
public class bibleDataService implements dataAccessInterface {

    /**
     * Default constructor. 
     */
    public bibleDataService() {
        // TODO Auto-generated constructor stub
    }

    String url = "jdbc:postgresql://localhost:5432/postgres";
	String username = "postgres";
	String password = "Kurume"; 
	
	public String returnVerse(int bookNumber, int chapter, int verse) {
		// TODO Auto-generated method stub
		
		
		Connection conn = null;
		
		
		String sql = "SELECT t FROM benchmark.t_kjv " 
				+ "WHERE b = " + bookNumber
				+ "AND c = " + chapter
				+ "AND v = " + verse;
		
		
		String verse1 = "Invalid book please try again";
		try
		{
			//Connecting to database
			conn = DriverManager.getConnection(url, username, password);
			
			//Execute SQL Query and loop
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				verse1 = rs.getString("t");
			}
			
			conn.close();
			
			return verse1;
		}
		catch (SQLException e)
		{
			
			e.printStackTrace();
			return null;
			
		}
		finally
		{
			//Database cleaning
			if(conn != null)
			{
				try
				{
					conn.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			
		}
		
	}

}
