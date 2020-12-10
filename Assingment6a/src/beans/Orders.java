package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;


@ManagedBean
@ViewScoped
@XmlRootElement
public class Orders {

	
	//List of the order object
	List<Order> myOrders = new ArrayList<Order>();
	
	
	//Default constructor  
	public Orders()
	{
		
	}

	//getter for myOrders
	public List<Order> getMyOrders() {
		return myOrders;
	}

	//setter for myOrders
	public void setMyOrders(List<Order> myOrders) {
		this.myOrders = myOrders;
	}
	
	
}
