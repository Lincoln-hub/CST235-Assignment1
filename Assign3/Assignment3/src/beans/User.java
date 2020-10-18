package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean
@ViewScoped 
public class User 
{
	//validation constraints 
	@NotNull(message = "please enter a First Name. This is a required field")
	@Size(min=4, max=15)
	String firstname = "";
	
	//validation constraints
	@NotNull(message = "please enter a Last Name. This is a required field")
	@Size(min=4, max=15)
	String lastname = "";
	
	//default constructor
	public User() 
	{
		firstname = "Lincoln";
		lastname = "Munago";
	}

	//Getters and Setters for firstName and lastName
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	

}
