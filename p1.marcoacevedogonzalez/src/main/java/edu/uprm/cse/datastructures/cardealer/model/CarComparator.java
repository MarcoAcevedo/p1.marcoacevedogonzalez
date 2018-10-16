package edu.uprm.cse.datastructures.cardealer.model;

import java.util.*;
import edu.uprm.cse.datastructures.cardealer.model.Car;

public class CarComparator implements Comparator<Car>{
	private int value;
	
	public CarComparator(int v) {
		value=v;
	}
	
	public int getValue() {
		return value;
	} 
	    
	public String toString() {
		return value + "";
	}

	
	/* 
	 * class that compares two cars based on a string formed with brand,
	 * model and options. For example, ToyotaRav4LE goes before ToyotaRav4SE.
	 * And Honda cars go before Toyota cars.
	 */

	@Override
	public int compare(Car c1, Car c2) {
		// System.out.println("You reached CarComparator.compare(Car c1, Car c2)");
		int brand, model, option;
		brand = ((c1.getCarBrand())).compareTo(c2.getCarBrand());
		model = (c1.getCarModel()).compareTo(c2.getCarModel());
		option = (c1.getCarModelOption()).compareTo(c2.getCarModelOption());
		if(brand!=0) {
			value=brand;
			return value;
		}
		if(model!=0) {
			value=model;
			return value;
		}
		value=option;
		return value;
	}

}
