package com.activityplanner.client;

public class BinaryTree<E> {
	public Node<E> root;
	private Node<E> pointer;
	
	private StringBuilder strBuilder;
	
	// Constructor
	public BinaryTree() {
		root = null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	// Add Node
	@SuppressWarnings("unchecked")
	public <E extends Comparable <E>> void add(E value, E date) {
		if(isEmpty()) {
			root = new Node(value, date);
			pointer = root;
		}else {
			pointer = root;
			while(true) {
				// If date is smaller
				if(((Comparable<E>) pointer.date).compareTo(date) >= 0) {
					if(pointer.left != null) {
						pointer = pointer.left;
					}else {
						pointer.left = new Node(value, date);
						break;
					}
				}else if(((Comparable<E>) pointer.date).compareTo(date) < 0) {
					if(pointer.right != null) {
						pointer = pointer.right;
					}else {
						pointer.right = new Node(value, date);
						break;
					}
				}
			}
		}
	}
	
	public <D extends Comparable <D>> boolean replace(E value, D date) {
		if(isEmpty()) {
			return false;
		}else {
			pointer = root;
			while(true) {
				if(((Comparable<D>) pointer.date).compareTo(date) == 0){
					pointer.value = (E) value;
					return true;
				}else if(((Comparable<D>) pointer.date).compareTo(date) > 0) {
					if(pointer.left != null) {
						pointer = pointer.left;
					}else {
						return false;
					}
				}else if(((Comparable<D>) pointer.date).compareTo(date) < 0) {
					if(pointer.right != null) {
						pointer = pointer.right;
					}else {
						return false;
					}
				}
			}
		}
	}
	
	public <D extends Comparable <D>> boolean replace(E value, D date, int num) {
		if(isEmpty()) {
			return false;
		}else {
			pointer = root;
			while(true) {
				if(((Comparable<D>) pointer.date).compareTo(date) == 0){
					return true;
				}else if(((Comparable<D>) pointer.date).compareTo(date) > 0) {
					if(pointer.left != null) {
						pointer = pointer.left;
					}else {
						return false;
					}
				}else if(((Comparable<D>) pointer.date).compareTo(date) < 0) {
					if(pointer.right != null) {
						pointer = pointer.right;
					}else {
						return false;
					}
				}
			}
		}
	}
	
	// Search Activity with date parameter
	public <E extends Comparable <E>> E search(E date) {
		if(isEmpty()) {
			return null;
		}else {
			pointer = root;
			while(true) {
//				System.out.println("Search for: " + pointer.value + " ");
				if(((Comparable<E>) pointer.date).compareTo(date) == 0) {
					return (E) pointer.value;
				}else if(((Comparable<E>) pointer.date).compareTo(date) > 0) {
					if(pointer.left != null) {
						pointer = pointer.left;
					}else {
						return null;
					}
				}else if(((Comparable<E>) pointer.date).compareTo(date) < 0) {
					if(pointer.right != null) {
						pointer = pointer.right;
					}else {
						return null;
					}
				}
			}
		}
	}
	
	
	// Display Node in String
	public String toString() {
		strBuilder = new StringBuilder();
		pointer = root;
		return traverse(pointer);
	}
	
	public String traverse(Node<E> root) {
		if(root.left != null) {
			traverse(root.left);
		}
		strBuilder.append(root.value + "-" + root.date + "\n");
		if(root.right != null) {
			traverse(root.right);
		}
		return strBuilder.toString();
	}
	
	// NODE
	public class Node<E>{
		E value;
		E date;
		Node<E> right;
		Node<E> left;
		
		// Constructor
		Node(E value, E date, Node<E> right, Node<E> left){
			this.value = value;
			this.date = date;
			this.right = right;
			this.left = left;
		}
		Node(E value, E date){
			this(value, date, null, null);
		}
	}
}
