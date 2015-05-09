package ui;

import java.util.ArrayList;

public class FunWithCollections {

	public static void main(String[] args) {
		
		ArrayList<String> myArrayList = new ArrayList<String>();
		
		myArrayList.add("first item");
		boolean result = myArrayList.add("second item");
		
		System.out.println(result);
		myArrayList.add("third item");
		myArrayList.add("fourth item");
		
		System.out.println(myArrayList.size());
		
		myArrayList.remove(1);
		myArrayList.add("fifth item");
		myArrayList.add(1, "sixth item");
		
		for(int i =0 ; i < myArrayList.size(); i++) {
			System.out.println(myArrayList.get(i));
		}

	}

}
