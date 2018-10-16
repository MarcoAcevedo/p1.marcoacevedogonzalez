package edu.uprm.cse.datastructures.cardealer.util;

import java.util.stream.Collectors;
import edu.uprm.cse.datastructures.cardealer.model.Car;
import edu.uprm.cse.datastructures.cardealer.model.CarComparator;

import java.util.Comparator;
import java.util.Iterator;

public class CircularSortedDoublyLinkedList<E> implements SortedList<E> {
	private DNode<E> header; 
	private int length; 
	private Comparator<E> cmp;
	
	
	public CircularSortedDoublyLinkedList(Comparator<E> comp) { 
		header = new DNode<E>();
		length =0;
		cmp = comp;
	}

	@Override
	public boolean add(E obj) { //Done
		
		if(length==0) {
			addBetween(header, header,obj);
			return true;
		}
		else {
			DNode<E> nodoNuevo = header;
			while(nodoNuevo.getNext()!=header && cmp.compare(obj,nodoNuevo.getNext().getElement())<=0) {
				nodoNuevo=nodoNuevo.getNext();
			}
			
			addBetween(nodoNuevo,nodoNuevo.getNext(),obj);
			
			return true;
		}
		
	}


	
	private void addBetween(DNode<E> n1, DNode<E> n2, E obj) { //Done
		DNode<E> nodoNuevo = new DNode<E>(obj);
		
		n1.setNext(nodoNuevo);
		n2.setPrev(nodoNuevo);
		nodoNuevo.setNext(n2);
		nodoNuevo.setPrev(n1);
		
		length++;
	}
	
	@Override
	public int size() { //Done
		return length;
	}

	@Override
	public boolean remove(E obj) { //Done
		
		if(length<=0) {
			throw new EmptyListException("CircularSortedDoublyLinkedList.removeAll(E obj) can not be executed because the list is empty.");
		}
		if(!contains(obj)) {
			return false;
		}
		
		DNode<E> nodo = header.getPrev();
		while(nodo.getPrev()!=header && cmp.compare(obj,nodo.getElement())!=0) {
			nodo=nodo.getPrev();
		}
		
		nodo.getPrev().setNext(nodo.getNext());
		nodo.getNext().setPrev(nodo.getPrev());
		nodo.cleanLinks();
		length--;
		return true;
	}

	@Override
	public boolean remove(int index) { //Done
		int i=1;
		if(index<=0 || index>length) {
			throw new IndexOutOfBoundsException("CircularSortedDoublyLinkedList.remove(int "+index+") index is out of bounds");
		}
		DNode<E> nodo = header.getNext();
		while(i!=index) {
			nodo=nodo.getNext();
			i++;
		}
		
		nodo.getPrev().setNext(nodo.getNext());
		nodo.getNext().setPrev(nodo.getPrev());
		nodo.cleanLinks();
		length--;
		return true;
		
	}

	@Override
	public int removeAll(E obj) { //Done
		int count =0;
		if(length<=0) {
			throw new EmptyListException("CircularSortedDoublyLinkedList.removeAll(E obj) can not be executed because the list is empty.");
		}
		if(!contains(obj)) {
			return count;
		}
		
		
		
		while(contains(obj)) {
			remove(obj);
			count++;
		}
		return count;
	}

	@Override
	public E first() { //Done
		return header.getNext().getElement();
	}

	@Override
	public E last() { //Done
		return header.getPrev().getElement();
	}

	@Override
	public E get(int index) { //Done
		if(index<0||index>length) {
			throw new IndexOutOfBoundsException("The index: "+index+" is out of the domain of the CircularSortedDoublyLinkedList");
		}
		
		int i=0;
		
		
		DNode<E> nodo = header.getNext();
		
		while(i!=index) {
			nodo=nodo.getNext();
			i++;
		}
		return nodo.getElement();
	}

	@Override
	public void clear() { //What

	}

	@Override
	public boolean contains(E e) { //Done
		if(isEmpty()) {
			return false;
		}
		
		DNode<E> nodo = header.getNext();
		
		if(size()==1) {
			return (cmp.compare(nodo.getElement(),e)==0);
		}
		
		while((nodo!=header)&&(cmp.compare(nodo.getElement(),e)!=0)) {
			nodo=nodo.getNext();
		}
		return (cmp.compare(nodo.getElement(),e)==0);
	}

	@Override
	public boolean isEmpty() { //Done
		return length==0;
	}

	@Override
	public int firstIndex(E e) {	
	return 0;
	}

	@Override
	public int lastIndex(E e) {
		return 0;
	}
	
	
	
	
private static class DNode<E> implements Node<E> {
	private E element; 
	private DNode<E> prev, next; 

	public DNode() {
		
	}
	
	public DNode(E e) { 
		element = e; 
	}
	
	public DNode(E e, DNode<E> p, DNode<E> n) { 
		prev = p; 
		next = n; 
	}
	
	
	public DNode<E> getPrev() {
		return prev;
	}
	
	public void setPrev(DNode<E> prev) {
		this.prev = prev;
	}
	
	public DNode<E> getNext() {
		return next;
	}
	
	public void setNext(DNode<E> next) {
		this.next = next;
	}
	
	public E getElement() {
		return element; 
	}

	public void setElement(E data) {
		element = data; 
	} 
	
	/**
	 * Just set references prev and next to null. Disconnect the node
	 * from the linked list.... 
	 */
	public void cleanLinks() { 
		prev = next = null; 
	}
	
}



	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}








}
