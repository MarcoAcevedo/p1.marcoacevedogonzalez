package edu.uprm.cse.datastructures.cardealer;

import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;

import javax.ws.rs.core.Response;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

import edu.uprm.cse.datastructures.cardealer.model.Car;
import edu.uprm.cse.datastructures.cardealer.util.CircularSortedDoublyLinkedList;
import edu.uprm.cse.datastructures.cardealer.util.SortedList;

@Path("/car")
public class CarManager {
	 private final CarList list = new CarList();
	// private final SortedList<Car> list = new CircularSortedDoublyLinkedList();
	 
	/*method to read all cars as an array of cars
	 * http://localhost:8080/cardealer/cars/
	*/
	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public Car[] readAsArray() { //Done
		Car[] carArray = new Car[list.size()];
		
		if(!list.isEmpty()){
		
			for(int i=0;i<list.size()-1;i++) {
				carArray[i]=list.get(i);
			}
		}
		return carArray;
	}
	
	
	
	/* Method to read a car with a given id
	 * http://localhost:8080/cardealer/cars/{id}
	 */
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Car getFromID(@PathParam("carId") long id){ //Done
		
		int i=0;
		while(list.get(i).getCarId()!=id) {
			i++;
		}
		return list.get(i);
		
	}
	
	
	
	/* Method to add a new car to the system
	 * http://localhost:8080/cardealer/add
	 */
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addNew(Car newCar) { //DoneSketchy
		list.add(newCar);
		return Response.status(201).build();
	}
	
	
	
	/* Method to update an existing car in the system
	 * http://localhost:8080/cardealer/cars/{id}/update
	 */
	@PUT
	@Path("{id}/update")
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(Car c) {
		int i=0;
		while(list.get(i).getCarId()!=c.getCarId()) {
			i++;
		}
		list.remove(i);
		list.add(c);
		return Response.status(Response.Status.NOT_FOUND).build();
	}
	
	
	
	/* Method to delete an existing car from the system
	 * http://localhost:8080/cardealer/cars/{id}/delete
	 */
	@DELETE
	@Path("/remove/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@PathParam("id") long id) { //Done
		int i = 0;
		while(list.get(i).getCarId()!=id) {
			i++;
		}
		
		list.remove(i);
	}
}
