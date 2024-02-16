package java8.employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmpDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       List<Employee> employeeList = new ArrayList<>();
       
       employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
       employeeList.add(new Employee(122, "Paul Niksui", 35, "Male", "Sales And Marketing", 2015, 13500.0));
       employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
       employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
       employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
       employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
       employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
       employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
       employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
       employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
       employeeList.add(new Employee(211, "Jasna Kaur", 37, "Female", "Infrastructure", 2014, 15700.0));
       employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
       employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
       employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
       employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
       employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
       employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

       
       //employeeList.forEach(e -> System.out.println(e));
       
       //How many male and female employees are there in the organization?
       
       //Map<String, Long> maleFemale = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
       Map<String, Long> maleFemale = employeeList.stream().collect(Collectors.groupingBy(e-> e.getGender() , Collectors.counting()));
      System.out.println(maleFemale);
       
       //Name of All Department
       employeeList.stream().map(e -> e.getDepartment()).distinct().forEach(e -> System.out.println(e));
       //employeeList.stream().map(Employee:: getDepartment).distinct().forEach(System.out::println);
      // List<String> depList = employeeList.stream().map(e -> e.getDepartment()).distinct().collect(Collectors.toList());
      // System.out.println(depList);
       
       //Average Age of Male and Female Employee
       Map<String, Double> avgAge = employeeList.stream().collect(Collectors.groupingBy(e -> e.getGender(), Collectors.averagingInt(e-> e.getAge())));
       System.out.println(avgAge);
       
       //Get the details of highest paid employee in the organization?
       Employee employee1 = employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))).get();
       System.out.println(employee1);
       
       Employee employee = employeeList.stream().collect(Collectors.maxBy(Comparator.comparingInt(Employee::getAge))).get();
       //System.out.println(employee);
       
       //5 : Get the names of all employees who have joined after 2015?
       List<String> list = employeeList.stream().filter(emp -> emp.getYearOfJoining() >2015).map(Employee :: getName).collect(Collectors.toList());
       list.forEach(System.out::println);
       
       //.6 : Count the number of employees in each department?
       Map<String,Long> empl = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
       //System.out.println(empl);

		/*
		 * Set<Entry<String, Long>> entrySet = empl.entrySet(); for(Entry<String, Long>
		 * entry : entrySet) { System.out.println(entry.getKey() + ":" +
		 * entry.getValue()); }
		 */
       
       // 7 : What is the average salary of each department?
       Map<String,Double> collect = employeeList.stream().collect(Collectors.groupingBy(Employee:: getDepartment, Collectors.averagingDouble(Employee:: getSalary)));
     //  System.out.println(collect);
       
       // 8 Get the details of youngest male employee in the product development department?
       
       //Employee collect2 = employeeList.stream().filter(emp -> emp.getDepartment().equalsIgnoreCase("Product Development") && emp.getGender().equalsIgnoreCase("male")).collect(Collectors.minBy(Comparator.comparing(Employee:: getAge) )).get();
       Employee minage = employeeList.stream().filter(emp -> emp.getDepartment().equalsIgnoreCase("Product Development") && emp.getGender()=="Male").min(Comparator.comparingInt(Employee::getAge)).get();
       System.out.println(minage);
       
       //9 Who has the most working experience in the organization?
      // Employee employee2 = employeeList.stream().min(Comparator.comparingInt(Employee::getYearOfJoining)).get();
        Employee employee2 = employeeList.stream().sorted(Comparator.comparingInt(Employee:: getYearOfJoining)).findFirst().get();
       System.out.println("Most Experience Emp : " + employee2);
       
       //10 How many male and female employees are there in the sales and marketing team?
       Map<String, Long> collect2 = employeeList.stream().filter(e -> e.getDepartment().equalsIgnoreCase("sales and marketing")).collect(Collectors.groupingBy(Employee:: getGender, Collectors.counting()));
       System.out.println(collect2);
       
       
       //11 What is the average salary of male and female employees?
       Map<String,Double> collect3 = employeeList.stream().collect(Collectors.groupingBy(Employee :: getGender, Collectors.averagingDouble(Employee :: getSalary)));
       System.out.println(collect3);
       
       
       //12 List down the names of all employees in each department?
       Map<String,List<Employee>> collect4 = employeeList.stream().collect(Collectors.groupingBy(Employee:: getDepartment));
       Set<Entry<String,List<Employee>>> entrySet = collect4.entrySet();
		/*
		 * for(Entry<String, List<Employee>> entry : entrySet) {
		 * System.out.println("Name Of Department :" + entry.getKey() );
		 * System.out.println("------------------------"); List<Employee> list2 =
		 * entry.getValue(); // list2.forEach(e -> System.out.println(e.getName()));
		 * for(Employee e : list2) System.out.println(e.getName());
		 * System.out.println("---------------"); }
		 */
       //System.out.println(collect4);
       
       
       
       //13 What is the average salary and total salary of the whole organization?
        DoubleSummaryStatistics summarize = employeeList.stream().collect(Collectors.summarizingDouble(Employee ::getSalary));
       System.out.println("Avg Salary :" + summarize.getAverage() +" and Total Salary :" + summarize.getSum());
       System.out.println("Max : "+ summarize.getMax()  +" Min : " + summarize.getMin() + " Count : " + summarize.getCount());
       
       
       
       //14 Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
		/*
		 * Map<Boolean, List<Employee>> partitionEmployeesByAge=
		 * employeeList.stream().collect(Collectors.partitioningBy(e -> e.getAge() >
		 * 25));
		 * 
		 * Set<Entry<Boolean, List<Employee>>> entrySet1 =
		 * partitionEmployeesByAge.entrySet();
		 * 
		 * for (Entry<Boolean, List<Employee>> entry : entrySet1) {
		 * System.out.println("----------------------------");
		 * 
		 * if (entry.getKey()) { System.out.println("Employees older than 25 years :");
		 * } else { System.out.println("Employees younger than or equal to 25 years :");
		 * }
		 * 
		 * System.out.println("----------------------------");
		 * 
		 * List<Employee> list = entry.getValue();
		 * 
		 * for (Employee e : list) { System.out.println(e.getName()); } }
		 */
       
       //15 Who is the oldest employee in the organization? What is his age and which department he belongs to
       
       Employee emp3 = employeeList.stream().collect(Collectors.maxBy(Comparator.comparingInt(Employee :: getAge))).get();
       System.out.println(emp3.getName() + ":"+ emp3.getAge() +":" + emp3.getDepartment());
	}

}
