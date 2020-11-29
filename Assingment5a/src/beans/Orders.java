package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;


@ManagedBean
@ViewScoped
public class Orders {

	
	//List of the order object
	List<Order> myOrders = new ArrayList<Order>();
	
	
	//Default constructor  
	public Orders()
	{
		//myOrders.add(new Order("254982","Cashmere Coat",(float)1000,4));
		//myOrders.add(new Order("254893","Alpaca Coat",(float)1500,2));
		//myOrders.add(new Order("254894","Vicuna Coat",(float)5000,1));
		
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
