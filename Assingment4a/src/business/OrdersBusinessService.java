package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Order;

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
    public OrdersBusinessService() 
    {
    	
    	orders.add(new Order("452333","Ferrari", 200000 , 1 ));
        orders.add(new Order("452334","Maserati", 120000, 2 ));
        orders.add(new Order("452335","Alfa Romeo", 90000, 3 ));
    	
    }

	/**
     * @see OrdersBusinessInterface#test()
     */
    public void test() {
        // TODO Auto-generated method stub
    	System.out.println("Hello from the OrdersBusinessService");
    }
    
    public List<Order> getOrders()
    {
    	return orders;
    }
    
    public void setOrders(List<Order> orders) 
    {
    	this.orders = orders;
    }

}
