package ui;

import java.util.ArrayList;

public class FunWithCollections {

	public static void main(String[] args) {
		
		ArrayList<String> myArrayList = new ArrayList<String>();
		
		myArrayList.add("First item");
		boolean result = myArrayList.add("Second item");
		
		System.out.println(result);
		myArrayList.add("Third item");
		myArrayList.add("Fourth item");
		
		System.out.println(myArrayList.size());
		
		myArrayList.remove(1);
		myArrayList.add("Fifth item");
		myArrayList.add(1, "Sixth item");
		
		for(int i =0 ; i < myArrayList.size(); i++) {
			System.out.println(myArrayList.get(i));
		}

	}

}
