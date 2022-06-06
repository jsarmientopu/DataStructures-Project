package datos;

import java.io.Serializable;
import java.util.EmptyStackException;

public class Stack<T> implements Serializable{

	private Node head;
	private int size;
	
	public Stack() {
		Node newHead = new Node();
		this.head = newHead;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public int size() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public T peek() {
		if( isEmpty() == false ) {
			return (T) head.getData();
		}else {
			throw new EmptyStackException();
		}
	}
	
	public void push( T element) {
		Node newNode = new Node( element);
		Node current = head;
		if(isEmpty()) {
			head = newNode;
		}else {
			newNode.setNext(head);
			head = newNode;
		}
		size += 1;
	}
	
	public T pop() {
		Node current = head;
		T element = null;
		element = (T) head.getData();
		if(size > 1) {
			head = head.getNext();
		}else if(size == 1) {
			this.head = null;
		}else {
			return null;
		}
		size -= 1;
		return element;
	}
	
	public void checkIndex(int index) {
		if((index >= size)||(index < 0)) {
			throw new IndexOutOfBoundsException("index = " + index + "  size = " + size);
		}
	}
	
	public T get(int index) {
		checkIndex(index);
		Node current = head;
		T element = null;
		for(int i =0; i< size; i++) {
			if(i == index) {
				element = (T) current.getData();
			}
			current = current.getNext();
		}
		return element;
	}
	
	public String toString() {
		String message = "[";
		Node current = this.head;
		for(int i = 0 ; i< size; i++) {
			message +=  current.getData() + ", ";
			current = current.getNext();
		}
		message = message.substring(0, message.length()-2);
		message += "]";
		return message;
	}
	
}