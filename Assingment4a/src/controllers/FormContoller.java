package controllers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.User;
import business.MyTimerService;
import business.OrdersBusinessInterface;


@ManagedBean
@ViewScoped
public class FormContoller 
{
	@Inject
	OrdersBusinessInterface service;
		
	@EJB
	MyTimerService timer;
	
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
		service.test();
		
		long num = 10000;
		timer.setTimer(num);
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
