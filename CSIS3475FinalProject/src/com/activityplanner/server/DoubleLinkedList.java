package com.activityplanner.server;

import java.io.Serializable;

/*LinkedList which saves the current and future data*/
public class DoubleLinkedList<E> implements Serializable{
	private static final long serialVersionUID = -6698184183194954987L;
	
	public Node<E> first;
	public Node<E> last;
	
	// Constructor
	public DoubleLinkedList() {
		this.first = null;
		this.last = null;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int getSize() {
		Node<E> pointer = first;
		int counter = 0;
		while(pointer != null) {
			pointer = pointer.next;
			counter++;
		}
		return counter;
	}
	
	public void add(E data) {
		if(isEmpty()) {
			last = new Node<E>(data);
			first = last;
		}else {
			last.next = new Node<E>(data, null, last);
			last = last.next;
		}
	}
	
	public E search(E data) {
		Node<E> pointer = first;
		E value = null;
		while(pointer!=null) {
			value = pointer.data;
			pointer = pointer.next;
		}
		
		return value;
	}
	
	public Node<E> search(int index) {
		Node<E> pointer = first;
		for(int idx = 0; idx < index; idx++) {
			if(idx == index-1) {
				return pointer;
			}
			pointer = pointer.next;
		}
		
		return null;
	}
	
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		Node<E> pointer = first;
		while(pointer != null) {
			strBuilder.append(pointer.data + "\n");
			pointer = pointer.next;
		}
		return strBuilder.toString();
	}
}
