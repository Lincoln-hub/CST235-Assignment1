package controllers;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.User;
import business.MyTimerService;
import business.OrdersBusinessInterface;
import data.DataAccessInterface;


@ManagedBean
@ViewScoped
public class FormContoller 
{
	@Inject
	OrdersBusinessInterface service;
	
	@EJB
	DataAccessInterface testingService;
		
	@EJB
	MyTimerService timer;
	
	
	
	/*private void getAllOrders() 
	{
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "Kurume";
		Connection con = null;
		String sql = "SELECT * FROM testapp.orders";
		
		try 
		{
			//connecting to the database
			con = DriverManager.getConnection(url,username,password);
			
			//Execute SQL Query and loop over result set
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) 
			{
				System.out.println(rs.getInt("ID") + " "+ rs.getString("PRODUCT_NAME") + " "+ rs.getFloat("PRICE"));
			}
			rs.close();
			//System.out.println("Success........!!!!");
	     	//con.close();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
			System.out.println("Failure.....!!!!!");
		}
		
	}*/
	
	/*public void insertOrder() 
	{
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "Kurume";
		Connection conn = null;
		String sql = "INSERT INTO  testapp.ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY)  VALUES('001122334455', 'This was inserted new', 25.00, 100)";
		
		try 
		{
			conn = DriverManager.getConnection(url,username,password);
			
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
			stmt.close();
		}
		catch(SQLException se) 
		{
			
			
			se.printStackTrace();
		}
		
	}*/
	
	public String onSubmit() 
	{
		//user managed bean
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
	
		//forward to test response view along with the user managed bean
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		return "TestResponse.xhtml";
	}
	
	public String onSubmit(User user) 
	{
		
		
		
		
		//long num = 10000;
		//timer.setTimer(num);
		
		
		System.out.println("Testing Create and find by ID CRUD methods ............");
		//testingService.test1();
		
		service.test();
	
		//Forward to test response view along with the User Managed Bean
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		return "TestResponse.xhtml";
	}
	
	public String onFlash(User user) 
	{
		//Redirect to Test Response View using Flash Scope with the User Managed Bean
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		return "TestResponse2.xhtmal?faces-redirect=true";
	}
	
	public OrdersBusinessInterface getService() 
	{
		return service;
	}

}
