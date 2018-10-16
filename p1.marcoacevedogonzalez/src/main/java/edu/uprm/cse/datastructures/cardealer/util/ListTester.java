package edu.uprm.cse.datastructures.cardealer.util;
import edu.uprm.cse.datastructures.cardealer.CarList;
import edu.uprm.cse.datastructures.cardealer.model.Car;

public class ListTester {
	public static void main(String[] args) {
		final SortedList<Car> list2 = new CarList();
		
		
		
		
		System.out.println("Testing: Adding 1 car to test list.....");
		Car c = new Car(1,"Honda","Accord","LX",7000);
		Car e = new Car(1,"AToyota","Yaris","S",5000);
		list2.add(c);
		System.out.println("Added: "+c.toString()+"\n\n");
		
		
		
		
		System.out.println("testing list.Contains(c).....");
		if(list2.contains(c)) {
			System.out.println("List recognizes car c\n\n");
		}
		else {
			System.out.println("list does not recognize car c\n\n");
		}
		
		
		
		
		
		System.out.println("testing list.first().toString().....");
		System.out.println("if you see something after the arrow sucess ---> "+list2.first().toString()+"\n\n");
		
		
		
		
		System.out.println("Testing list2.firstIndex(c).....");
		System.out.println("The firstIndex(c) is: "+ list2.firstIndex(c)+"\n\n");
		
		
		
		System.out.println("Testing list2.lastIndex(c).....");
		System.out.println("The lastIndex(c) is: "+ list2.lastIndex(c)+"\n\n");
		
		
		
		
		System.out.println("Testing contains(c).....");
		if(list2.contains(c)) {
			System.out.println("SUCESS\n\n");
		}
		else {
			System.out.println("FAILED\n\n");
		}
		
		System.out.println("Testing contains(e).....");
		if(list2.contains(e)) {
			System.out.println("FAILED\n\n");
		}
		else {
			System.out.println("SUCCESS\n\n");
		}
		
		
		
		System.out.println("Testing remove(c).....");
		if(list2.remove(c)) {
			System.out.println("Removed c succesfully\n\n");
			
		}
		else {
			System.out.println("Remove FAILED\n\n");
		}
		
		
		
		
		
		
		System.out.println("Adding a second car to the list......");
		if(list2.add(e)) {
			System.out.println("SUCCESS\n\n");
		}
		else {
			System.out.println("FAILED\n\n");
		}
		
		
		
		
		System.out.println("testing list.Contains(e)");
		if(list2.contains(e)) {
			System.out.println("List recognizes car e\n\n");
		}
		else {
			System.out.println("list does not recognize car e\n\n");
		}
		
		
		System.out.println("Testing if car e was sorted first than c.....");
		System.out.println(""+ list2.get(0).toString()+"\n\n");
		
	}
}
