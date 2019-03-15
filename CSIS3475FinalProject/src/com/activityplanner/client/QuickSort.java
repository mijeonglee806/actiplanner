package com.activityplanner.client;

import com.activityplanner.server.Node;

public class QuickSort<E> {
	Node<E> head;
	Node<E> first;
	
	public QuickSort(Node<E> node) {
		first = node;
		head = lastNode(node);
		sort(first, head);
	}
	
	private Node<E> partition(Node<E> low, Node<E> high){
		Double pivot = getTemp(high.data);
		Node<E> i = low.prev;
		Node<E> pointer = low;
		while(pointer != high) {
			Double value = getTemp(pointer.data);
			if(value <= pivot) {
				i = (i == null)? low : i.next;
				E temp = i.data;
				i.data = pointer.data;
				pointer.data = temp;
			}
			pointer = pointer.next;
		}
		
		i = (i == null)? low : i.next;
		E temp = i.data;
		i.data = high.data;
		high.data = temp;
		
		return i;
	}
	
	public void sort(Node<E> low, Node<E> high) {
		if(high != null && low != high && low != high.next) {
			Node<E> temp = partition(low, high);
			sort(low, temp.prev);
			sort(temp.next, high);
		}
	}
	
	public String toString() {
		Node<E> pointer = first;
		StringBuilder strBuilder = new StringBuilder();
		while(pointer != null) {
			strBuilder.append(pointer.data + "\n");
			pointer = pointer.next;
		}
		
		return strBuilder.toString();
	}
	
	private Node<E> lastNode(Node<E> node){
		while(node.next != null) {
			node = node.next;
		}
		return node;
	}
	
	private Double getTemp(E data) {
		String[] temp = data.toString().split(",");
		return Double.parseDouble(temp[0]);
	}
}
