package collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListItteration {

	public ListItteration() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         List<String> pLang = Arrays.asList("Java", "C++", "Python", "Cobol");
         
         //Basic for loop
         for(int i=0; i<pLang.size(); i++) {
        	 System.out.println(pLang.get(i));
         }
         System.out.println("*********************");
         
         for (Iterator iterator = pLang.iterator(); iterator.hasNext();) {
			String lang = (String) iterator.next();
			System.out.println(lang);
			}
         System.out.println("Iterator with While loop:");
         Iterator iterator = pLang.iterator();
         while(iterator.hasNext()) {
        	 String nextelement = (String) iterator.next();
        	 System.out.println(nextelement);
         }
         
         System.out.println("Enhanced For Loop");
         for(String lang : pLang) {
        	 System.out.println(lang);
        	 
         }
         System.out.println("&&&&&&&&&&&&&");
         pLang.stream().forEach(n->System.out.println(n));
         
         System.out.println("###################");
         pLang.stream().forEach(System.out::println);
	}

}
