package business;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import beans.Order;
import data.DataAccessInterface;


/**
 * Session Bean implementation class OrdersBusinessService
 */
@Stateless
@Local(OrdersBusinessInterface.class)
@LocalBean
@Alternative
public class OrdersBusinessService implements OrdersBusinessInterface {

	@EJB
	DataAccessInterface service;
	
	@Resource(mappedName="java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(mappedName="java:/jms/queue/Order")
	private Queue queue;
	
	List<Order> orders = new ArrayList<Order>();
    /**
     * Default constructor. 
     */
	
	
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
       /*// Order newOrder =new Order(2,"000012365","The new order created by Create() method ",452,20);
        
        //orders.add(newOrder);
    	
    	service.create(newOrder);
    	
    	//int id  = newOrder.getId();
    	System.out.println("Found this order by id "+ 16 +" Product name:  " +service.findById(16).getProductName());
    	
    	Order updateOrder = new Order(14,"00009894","The updated order",600,200);
    	
    	service.update(updateOrder);
    	
    	service.delete(newOrder);*/
    	
    }
    
    public List<Order> getOrders()
    {
    	return service.findAll();
    }
    
    public void setOrders(List<Order> orders) 
    {
    	
    }

    
	public void sendOrder(Order order) 
	{
		// TODO Auto-generated method stub
		try 
		{
			Connection connection = connectionFactory.createConnection();
			Session  session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			MessageProducer messageProducer = session.createProducer(queue);
			
			TextMessage message1 = session.createTextMessage();
			message1.setText("This is test message");
			messageProducer.send(message1);
			
			ObjectMessage message2 = session.createObjectMessage();
			message2.setObject(order);
			messageProducer.send(message2);
			
			connection.close();
		} 
		catch (JMSException e) 
		{
			e.printStackTrace();
		}		

		
	}

}
