package data;

import beans.Order;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class OrdersDataService
 */
@Stateless
@Local(DataAccessInterface.class)
public class OrdersDataService implements DataAccessInterface {

    /**
     * Default constructor. 
     */
	//connecting to the database
	String url = "jdbc:postgresql://localhost:5432/postgres";
	String username = "postgres";
	String password = "Kurume";
    public OrdersDataService() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see DataAccessInterface#findAll()
     */
    public List<Order> findAll() {
        // TODO Auto-generated method stub
    	
    	List<Order> orders = new ArrayList<>();
    	
    	
		Connection con = null;
		String sql = "SELECT * FROM testapp.ORDERS";
		
		try 
		{
			//connecting to the database
			con = DriverManager.getConnection(url,username,password);
			
			//Execute SQL Query and loop over result set
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) 
			{
				orders.add(new Order(rs.getInt("ID"),rs.getString("Order_NO"),rs.getString("PRODUCT_NAME"),rs.getFloat("PRICE"),rs.getInt("QUANTITY")));
			}
			
			//Clean up
			rs.close();
			//System.out.println("Success........!!!!");
	     	//con.close();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
			System.out.println("Failure.....!!!!!");
		}
			return orders;
    }

    //findById() find an order using an id it recieves
	public Order findById(int id) 
	{
		Connection conn = null;	
		String sql = "SELECT * FROM testapp.ORDERS";
		Order order = null;
		int newId = id;
		
		try
		{
			//Connecting to database
			conn = DriverManager.getConnection(url, username, password);
			
			//Execute SQL Query and loop
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				
				//add new order with each new table
				if (rs.getInt("ID") == newId)
				{
					
					order = new Order(rs.getInt("ID"),
							rs.getString("ORDER_NO"), 
							rs.getString("PRODUCT_NAME"), 
							rs.getFloat("PRICE"),
							rs.getInt("QUANTITY"));
				}
			}
			
			
			conn.close();
			return order;
		}
		catch (SQLException e)
		{
			
			e.printStackTrace();
			return null;
			
		}
		finally
		{
			//Database cleaning
			if(conn != null)
			{
				try
				{
					conn.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			
		}
		
	}

	//create() inserts an order into the table
	public void create(Order order) 
	{
        Connection conn = null;
    	
    	Order newOrder = order;
    	//Default values for string
		String sql = "INSERT INTO  testapp.ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES(" + 
				newOrder.getOrderNumber() + ", '" +
				newOrder.getProductName()+ "', '" +
				newOrder.getPrice() + "', '" + 
				newOrder.getQuantity() + "')";
		try
		{
			conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//Database cleaning
			if(conn != null)
			{
				try
				{
					conn.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		
	}
	
	//update() updates an order in the table
	public void update(Order order)
	{
		Connection conn = null;
    	int id = order.getId();
    	Order updateOrder = order;
    	
    	
    	//Default values for string
		String sql = "UPDATE testapp.ORDERS SET " + 
				"ORDER_NO = "+ updateOrder.getOrderNumber() + ", " +
				"PRODUCT_NAME = '"+ updateOrder.getProductName() + "', " +
				"PRICE = '"+ updateOrder.getPrice() + "', " + 
				"QUANTITY = '"+ updateOrder.getQuantity() + "' WHERE ID =  " + id +";";
		
		try
		{
			conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//Database cleaning
			if(conn != null)
			{
				try
				{
					conn.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		
	}

	//delete() deletes an order from the table
	public void delete(Order order) 
	{
		
		Connection conn = null;
    	
    	int id = order.getId();
    	
    	String sql = "DELETE FROM testapp.ORDERS"+
    					" WHERE ID = " + id +";";
    	
    	try
		{
			conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//Database cleaning
			if(conn != null)
			{
				try
				{
					conn.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	public void test1() {}
	
    /*public  void test1() 
    {
    	Order newOrder =new Order(15,"000012365","The new order",452,20);
    	
    	create(newOrder);
    	
    	int id  = newOrder.getId();
    	System.out.println("Found this order by id "+ id +" "+ findById(id));
    	
    	//Order updateOrder = new Order(14,"00009894","The updated order",600,200);
    	
    	//update(updateOrder);
    	
    	//delete(updateOrder);
    }*/

}
