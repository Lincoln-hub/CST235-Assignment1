package beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Order implements Serializable {
	
	private static long sN = 1L;
	//declaring variables
	String orderNumber ="";
	String productName ="";
	float price= 0;
	int quantity = 0;
	int id =0;
	
	//default constructor
	public Order() 
	{
	}
	//parameterized constructor
	public Order(int ID, String orderNumber, String productName, float price, int quantity) 
	{
		this.id = ID;
		this.orderNumber =orderNumber;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	
	
	//getter for orderNumber
	public String getOrderNumber() {
		return orderNumber;
	}

	//setter for orderNumber
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	//getter for productName
	public String getProductName() {
		return productName;
	}

	//setter for productName
	public void setProductName(String productName) {
		this.productName = productName;
	}

	//getter for price
	public float getPrice() {
		return price;
	}

	//setter for orderNumber
	public void setPrice(float price) {
		this.price = price;
	}

	//getter for quantity
	public int getQuantity() {
		return quantity;
	}

	//setter for quantity
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
		
}
