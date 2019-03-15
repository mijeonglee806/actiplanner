package com.activityplanner.old;

public class BinaryTree<E> {
	private Node<E> root;
	private Node<E> pointer;
	
	// Constructor
	public BinaryTree() {
		root = null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public < E extends Comparable <E> > void add(E value) {
		if(isEmpty()) {
			root = new Node(value);
			pointer = root;
		}else {
			pointer = root;
			while(true) {
				if(((Comparable<E>) pointer.value).compareTo(value) >= 0 ) {
					if(pointer.left != null) {
						pointer = pointer.left;
					}else {
						pointer.left = new Node(value);
						break;
					}
				}else if(((Comparable<E>) pointer.value).compareTo(value) < 0) {
					if(pointer.right != null) {
						pointer = pointer.right;
					}else {
						pointer.right = new Node(value);
						break;
					}
				}
			}
		}
	}
	
	public <E extends Comparable <E>> String search(E value) {
		E result = value;
		if(isEmpty()) {
			return "Not Found!";
		}else {
			pointer = root;
			while(true) {
				System.out.println(pointer.value + " ");
				if(((Comparable<E>) pointer.value).compareTo(value) == 0) {
					return "Result: " + result;
				}
				else if(((Comparable<E>) pointer.value).compareTo(value) > 0) {
					if(pointer.left != null) {
						pointer = pointer.left;
					}else {
						return "Not Found!";
					}
				}else if(((Comparable<E>) pointer.value).compareTo(value) < 0) {
					if(pointer.right != null) {
						pointer = pointer.right;
					}else {
						return "Not found!";
					}
				}
			}
		}
	}
	
	// Node
	private class Node<E>{
		E value;
		Node<E> right;
		Node<E> left;
		
		// Constructor
		Node(E value, Node<E> right, Node<E> left){
			this.value = value;
			this.right = right;
			this.left = left;
		}
		Node(E value){
			this(value, null, null);
		}
	}
}
