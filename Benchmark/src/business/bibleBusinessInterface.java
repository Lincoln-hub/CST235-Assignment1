package business;

import javax.ejb.Local;

import beans.Scripture;

@Local
public interface bibleBusinessInterface {
	
	public String returnVerse(Scripture scripture);
	public int returnBook(Scripture scripture);

}
