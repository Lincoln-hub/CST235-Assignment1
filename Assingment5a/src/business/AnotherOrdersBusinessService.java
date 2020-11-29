package business;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import beans.Order;

/**
 * Session Bean implementation class AnotherOrdersBusinessService
 */
@Stateless
@Local(OrdersBusinessInterface.class)
@LocalBean
@Alternative
public class AnotherOrdersBusinessService implements OrdersBusinessInterface {

 
	List<Order> orders = new ArrayList<>();
	/**
     * Default constructor. 
     */
    public AnotherOrdersBusinessService() 
    {
        //orders.add(new Order("452333","Roberto Cavalli Loafers", 2000, 2 ));
        //orders.add(new Order("452334","Maison Magiela Loafers", 3000, 2 ));
        //orders.add(new Order("452335","Ermenegildo Zenga Loafers", 1000, 3 ));
    }

	/**
     * @see OrdersBusinessInterface#test()
     */
    public void test() {
        // TODO Auto-generated method stub
    	System.out.println("Hello from AnotherOrdersBusinessService");
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
