package business;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.faces.bean.ViewScoped;

import beans.Scripture;
import data.dataAccessInterface;

/**
 * Session Bean implementation class bibleBusinessService
 */
@Stateless
@Local(bibleBusinessInterface.class)
@LocalBean
@Alternative
@ViewScoped
public class bibleBusinessService implements bibleBusinessInterface {

    
	@EJB
	dataAccessInterface service;
	
	
    public bibleBusinessService() {
        // TODO Auto-generated constructor stub
    }

	
	public String returnVerse(Scripture scripture) {
	
		int bookNumber = returnBook(scripture);
		int chpt = scripture.getChpt();
		int verse = scripture.getVerse();
		
		
		return service.returnVerse(bookNumber, chpt, verse);
	}

	
	public int returnBook(Scripture script) {
		// TODO Auto-generated method stub
		
		String book = script.getBook();
		
		Map<String, Integer> myMap = new HashMap<String, Integer>();
		
		myMap.put("Genesis", 1);
		myMap.put("Exodus", 2);
		myMap.put("Leviticus", 3);
		myMap.put("Numbers", 4);
		myMap.put("Deuteronomy", 5);
		myMap.put("Joshua", 6);
		myMap.put("Judges", 7);
		myMap.put("Ruth", 8);
		myMap.put("1 Samuel", 9);
		myMap.put("2 Samuel", 10);
		myMap.put("1 King", 11);
		myMap.put("2 King", 12);
		myMap.put("1 Chronicles", 13);
		myMap.put("2 Chronicles", 14);
		myMap.put("Ezra", 15);
		myMap.put("Nehemiah", 16);
		myMap.put("Esther", 17);
		myMap.put("Job", 18);
		myMap.put("Psalm", 19);
		myMap.put("Proverbs", 20);
		myMap.put("Ecclesiastes", 21);
		myMap.put("Song of Solomon", 22);
		myMap.put("Isaiah", 23);
		myMap.put("Jeremiah", 24);
		myMap.put("Lamentations", 25);
		myMap.put("Ezekiel", 26);
		myMap.put("Daniel", 27);
		myMap.put("Hosea", 28);
		myMap.put("Joel", 29);
		myMap.put("Amos", 30);
		myMap.put("Obadiah", 31);
		myMap.put("Jonah", 32);
		myMap.put("Micah", 33);
		myMap.put("Nahum", 34);
		myMap.put("Habakkuk", 35);
		myMap.put("Zephaniah", 36);
		myMap.put("Haggai", 37);
		myMap.put("Zechariah", 38);
		myMap.put("Malachi", 39);
		myMap.put("Matthew", 40);
		myMap.put("Mark", 41);
		myMap.put("Luke", 42);
		myMap.put("John", 43);
		myMap.put("Acts", 44);
		myMap.put("Romans", 45);
		myMap.put("1 Corinthians", 46);
		myMap.put("2 Corinthians", 47);
		myMap.put("Galatians", 48);
		myMap.put("Ephesians", 49);
		myMap.put("Philippians", 50);
		myMap.put("Colossians", 51);
		myMap.put("1 Thessalonians", 52);
		myMap.put("2 Thessalonians", 53);
		myMap.put("1 Timothy", 54);
		myMap.put("2 Timothy", 55);
		myMap.put("Titus", 56);
		myMap.put("Philemon", 57);
		myMap.put("Hebrews", 58);
		myMap.put("James", 59);
		myMap.put("1 Peter", 60);
		myMap.put("2 Peter", 61);
		myMap.put("1 John", 62);
		myMap.put("2 John", 63);
		myMap.put("3 John", 64);
		myMap.put("Jude", 65);
		myMap.put("Revelation", 66);
		
		return myMap.get(book);
	}

}
