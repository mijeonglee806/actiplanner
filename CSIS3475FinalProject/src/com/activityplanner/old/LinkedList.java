package com.activityplanner.old;

public class LinkedList {
	private Node first;
	private Node last;
	
	public LinkedList() {
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int getSize() {
		int count = 0;
		Node pointer = first;
		while(pointer != null) {
			pointer = pointer.next;
			count++;
		}
		return count;
	}
	
	// Add
	public void add(String value, int date) {
		if(isEmpty()) {
			first = new Node(value, date);
			last = first;
		}else {
			last.next = new Node(value, date);
			last = last.next;
		}
	}
	
	public void add(String value, int date, int index) {
		if(!(index < 0 || index > getSize())) {
			if(index == 0) {
				first = new Node(value, date, first);
				if(last == null) {
					last = first;
				}
				return;
			}
			
			Node pointer = first;
			for(int idx = 1; idx <= index - 1; idx++) {
				pointer = pointer.next;
			}
			
			pointer.next = new Node(value, date, pointer.next);
			if(pointer.next.next == null) {
				last = pointer.next;
			}
		}
	}
	
	public boolean replace(String value, int date, boolean change) {
		Node pointer = first;
		while(pointer != null) {
			if(pointer.date == date) {
				if(change) {
					pointer.value = value;
					return true;
				}else {
					return true;
				}
			}
			pointer = pointer.next;	
		}
		return false;
	}
	
	public boolean remove(int date) {
		if(isEmpty()) {
			return false;
		}
		if(date == first.date){
			first = first.next;
			if(first == null) last = null;
			return true;
		}
		Node pointer = first;
		while(pointer.next != null && pointer.next.date != date) {
			pointer = pointer.next;
		}
		
		if(pointer.next == null) {
			return false;
		}
		
		pointer.next = pointer.next.next;
		if(pointer.next == null) {
			last = pointer;
		}
		return true;
	}
	
	public String search(int date) {
		Node pointer = first;
		
		for(int idx = 0; idx < getSize(); idx++) {
			if(pointer.date == date) {
				return pointer.value;
			}
			pointer = pointer.next;
		}
		
		return "";
	}
	
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		Node pointer = first;
		while(pointer != null) {
			strBuilder.append(pointer.value + "-" + pointer.date + "\n");
			pointer = pointer.next;
		}
		return strBuilder.toString();
	}
	
	
	// NODE
	private class Node
	{
		String value;
		int date;
		Node next;
		
		// Constructor
		Node(String value, int date, Node node){
			this.value = value;
			this.date = date;
			this.next = node;
		}
		Node(String value, int date){
			this(value, date, null);
		}
	}
}
