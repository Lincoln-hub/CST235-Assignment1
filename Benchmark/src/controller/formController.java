package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Scripture;
import business.bibleBusinessInterface;

@ViewScoped
@ManagedBean
public class formController 
{
	
	@Inject
	bibleBusinessInterface service;
	
	public String onSubmit(Scripture script) 
	{
		
		System.out.println("Is this working........?::::" + service.returnBook(script) + service.returnVerse(script));
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Scripture", script);
		return "ScriptureForm.xhtml";
	}

	
	public bibleBusinessInterface getService() 
	{
		return service;
	}
}
