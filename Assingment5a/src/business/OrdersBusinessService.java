package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import beans.Order;
import data.DataAccessInterface;
import data.OrdersDataService;

/**
 * Session Bean implementation class OrdersBusinessService
 */
@Stateless
@Local(OrdersBusinessInterface.class)
@LocalBean
@Alternative
public class OrdersBusinessService implements OrdersBusinessInterface {

	List<Order> orders = new ArrayList<Order>();
    /**
     * Default constructor. 
     */
	@EJB
	DataAccessInterface service;
	
	//default constructor
    public OrdersBusinessService() 
    {
    	
    }

	/**
     * @see OrdersBusinessInterface#test()
     */
    
    public void test() 
    {
        // TODO Auto-generated method stub
    	System.out.println("Hello from the OrdersBusinessService");
        Order newOrder =new Order(2,"000012365","The new order created by Create() method ",452,20);
        
        orders.add(newOrder);
    	
    	service.create(newOrder);
    	
    	//int id  = newOrder.getId();
    	System.out.println("Found this order by id "+ 16 +" Product name:  " +service.findById(16).getProductName());
    	
    	Order updateOrder = new Order(14,"00009894","The updated order",600,200);
    	
    	service.update(updateOrder);
    	
    	service.delete(newOrder);
    	
    }
    
    public List<Order> getOrders()
    {
    	return service.findAll();
    }
    
    public void setOrders(List<Order> orders) 
    {
    	
    }

}
