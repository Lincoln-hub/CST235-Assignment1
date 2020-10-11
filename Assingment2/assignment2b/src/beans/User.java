package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class User 
{
	//properties
	String firstName = "";
	String lastName = "";
	
	//default constructor to initialize properties
	public User() 
	{
		firstName = "Lincoln";
		lastName = "Munago";
	}

	//getter and setters to access properties
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
