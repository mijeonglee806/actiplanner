package com.activityplanner.server;

import java.io.Serializable;

public class Node<E> implements Serializable{
	private static final long serialVersionUID = -2961031738467659108L;
	
	public E data;
	
	public Node<E> next;
	public Node<E> prev;

	Node(E data, Node<E> next, Node<E> prev) {
		this.data = data;
		
		this.next = next;
		this.prev = prev;
	}

	Node(E data) {
		this(data, null, null);
	}
}
