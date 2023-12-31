package linkedList;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import javax.swing.text.html.HTMLDocument.Iterator;

public class LinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<String> lList = new LinkedList<>();
		lList.add("C");
		lList.add("Java");
		lList.add("Python");
		lList.add("C++");
		lList.add("Java");
		
		System.out.println(lList);
		//lList.add(0, null);
		lList.addFirst("Vikram");
		//lList.removeLast();
		System.out.println(lList);
		//String st = lList.getFirst();
		//System.out.println(st);
		
		//for Each using java 8
		lList.forEach(str-> System.out.println(str));
		
		//Normal for Loop
		System.out.println("Normal For Loop:");
		for(int i=0; i<lList.size(); i++) {
			System.out.println(lList.get(i));
		}
		
		System.out.println("Itrerator Loop:-");
		java.util.Iterator itr =  lList.iterator();
		while(itr.hasNext()) {
			String str = (String) itr.next();
			if(str.equalsIgnoreCase("java")) {
				continue;
			}else {
			System.out.println(str);
		}
		}
		//Advance For loop
		System.out.println("Advance for loop: ");
		for(String e : lList) {
			System.out.println(e);
		}

		//List<String> collect = lList.stream().distinct().collect(Collectors.toList());
		LinkedList<String> collect = lList.stream().filter(e-> !((e.equalsIgnoreCase("JAVA"))|| e.equalsIgnoreCase("viKRAm"))).collect(Collectors.toCollection(LinkedList::new));
		
		System.out.println(collect.toString());
}
}