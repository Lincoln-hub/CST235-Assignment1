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

import beans.Order;
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
	
	
	
	/*public String onSubmit() 
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
	}*/
	
	public String onFlash(User user) 
	{
		//Redirect to Test Response View using Flash Scope with the User Managed Bean
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		return "TestResponse2.xhtmal?faces-redirect=true";
	}
	
	public String onLogOff() 
	{
		// Invalidate the Session to clear the security token
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

		// Redirect to a protected page (so we get a full HTTP Request) to get Login Page
		return "TestResponse.xhtml?faces-redirect=true";
	}
	
	public String onSendOrder() 
	{
		Order order = new Order(1,"23556","Message Product",50,100);//for testing !!!!!!!!!!
		service.sendOrder(order);
		return "OrderResponse.xhtml";
	}
	
	public OrdersBusinessInterface getService() 
	{
		return service;
	}

}
