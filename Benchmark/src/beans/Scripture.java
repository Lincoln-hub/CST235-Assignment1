package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Scripture {
	
	String book = "Exodus";
	int chpt = 1;
	int verse = 1;
	
	//default constructor
	public Scripture() 
	{
		
	}
	
	//parameterized constructor
	public Scripture(String book, int chpt, int verse) 
	{
		this.book = book;
		this.chpt = chpt;
		this.verse = verse;
	}



	public void setBook(String book) {
		this.book = book;
	}

	public int getChpt() {
		return chpt;
	}

	public void setChpt(int chpt) {
		this.chpt = chpt;
	}

	public int getVerse() {
		return verse;
	}

	public void setVerse(int verse) {
		this.verse = verse;
	}

	public String getBook() {
		// TODO Auto-generated method stub
		return book;
	}
	
	

}
