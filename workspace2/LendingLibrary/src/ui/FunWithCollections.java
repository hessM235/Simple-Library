package ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import models.Book;

public class FunWithCollections {

	public static void main(String[] args) {
		
		ArrayList<String> myArrayList = new ArrayList<String>();
		HashSet<String> myHashSet = new HashSet<String>();
		
		myArrayList.add("First item");
		boolean result = myArrayList.add("Second item");
		
		System.out.println(result);
		myArrayList.add("Third item");
		myArrayList.add("Fourth item");
		
		myHashSet.add("first item");
		myHashSet.add("second item");
		myHashSet.add("third item");
		myHashSet.add("fourth item");
		
		System.out.println(myArrayList.size());
		System.out.println(myHashSet.size());
		
		myArrayList.remove(1);
		myHashSet.remove("second item");
		System.out.println(myHashSet.size());
		myArrayList.add("Fifth item");
		myArrayList.add(1, "Sixth item");
		
		for(int i =0 ; i < myArrayList.size(); i++) {
			System.out.println(myArrayList.get(i));
		}
		
		System.out.println("");
		
		Iterator<String> myIterator = myHashSet.iterator();
		while(myIterator.hasNext()) {
			String nextString = myIterator.next();
			System.out.println(nextString);
		}
		
		HashMap<String, Book> myHashMap = new HashMap<String, Book>();
		
		Book book1 = new Book(1,"first book", "", "", "", 100 );
		Book book2 = new Book(1,"second book", "", "", "", 100 );
		Book book3 = new Book(1,"third book", "", "", "", 100 );
		
		myHashMap.put(book1.getTitle(), book1);
		myHashMap.put(book2.getTitle(), book2);
		myHashMap.put(book3.getTitle(), book3);
		
		System.out.println(myHashMap.size());
		
		myHashMap.remove(book2.getTitle());
		System.out.println(myHashMap.size());
		myHashMap.put(book2.getTitle(), book2);
		
		Iterator<Book> myValues = myHashMap.values().iterator();
		while(myValues.hasNext()) {
			Book nextBook = myValues.next();
			System.out.println(nextBook.getTitle());
		}
		
		myHashMap.keySet().iterator();

	}

}
