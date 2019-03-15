package com.activityplanner.old;

import com.activityplanner.server.Node;

public class QuickSort<E> {
	Node<E> head;
	
	public QuickSort(Node<E> node) {
		head = lastNode(node);
//		sort(node, head);
	}
	
	private Node<E> lastNode(Node<E> node){
		while(node.next != null)
			node = node.next;
		return node;
	}
	
	
	private Node<E> partition(Node<E> low, Node<E> high){
		Double pivot = getTemp(high.data);
		Node<E> i = low.prev;
		Node<E> pointer = low;
		for(Node<E> j = low; j != high; j = j.next) {
			Double value = getTemp(pointer.data);
			if(value <= pivot) {
				i = (i == null) ? low : i.next;
				E temp = i.data;
				i.data = j.data;
				j.data = temp;
			}
			pointer = pointer.next;
		}
		
		i = (i==null)? low : i.next;
		E temp = i.data;
		i.data = high.data;
		high.data = temp;
		
		return i;
	}
	
	public void sort(Node<E> high, Node<E> low) {
		if(high != null && low != high && low != high.next) {
			Node<E> temp = partition(low, high);
			sort(low, temp.prev);
			sort(temp.next, high);
		}
	}
	
	// Get the string value
	public String getData(Node<E> node) {
		StringBuilder strBuilder = new StringBuilder();
		Node<E> pointer = node;
		while(pointer != null) {
			strBuilder.append(pointer.data + " ");
			pointer = pointer.next;
		}
		
		return strBuilder.toString();
	}
	
	private Double getTemp(E data) {
		String[] temp = data.toString().split(",");
		return Double.parseDouble(temp[0]);
	}
}
