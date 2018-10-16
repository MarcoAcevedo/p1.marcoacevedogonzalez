package edu.uprm.cse.datastructures.cardealer;
import edu.uprm.cse.datastructures.cardealer.util.SortedList;

import java.util.Comparator;
import java.util.Iterator;

import edu.uprm.cse.datastructures.cardealer.model.Car;
import edu.uprm.cse.datastructures.cardealer.model.CarComparator;
import edu.uprm.cse.datastructures.cardealer.util.CircularSortedDoublyLinkedList;


public class CarList implements SortedList<Car> {
	int num ;
	private Comparator<Car> cmp = new CarComparator(num);
	public SortedList<Car> list = new CircularSortedDoublyLinkedList<Car>(cmp);
	
	
	
	@Override
	public Iterator<Car> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Car obj) {
		// TODO Auto-generated method stub
		return list.add(obj);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public boolean remove(Car obj) {
		// TODO Auto-generated method stub
		return list.remove(obj);
	}

	@Override
	public boolean remove(int index) {
		// TODO Auto-generated method stub
		return list.remove(index);
	}

	@Override
	public int removeAll(Car obj) {
		// TODO Auto-generated method stub
		return list.removeAll(obj);
	}

	@Override
	public Car first() {
		// TODO Auto-generated method stub
		return list.first();
	}

	@Override
	public Car last() {
		// TODO Auto-generated method stub
		return list.last();
	}

	@Override
	public Car get(int index) {
		// TODO Auto-generated method stub
		return list.get(index);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		list.clear();
	}

	@Override
	public boolean contains(Car e) {
		// TODO Auto-generated method stub
		return list.contains(e);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
	}

	@Override
	public int firstIndex(Car e) {
		// TODO Auto-generated method stub
		return list.firstIndex(e);
	}

	@Override
	public int lastIndex(Car e) {
		// TODO Auto-generated method stub
		return list.lastIndex(e);
	}
	
	public SortedList<Car> getList(){
		return list;
	}

}
