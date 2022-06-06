package datos;

import java.io.Serializable;
import java.util.Objects;

public class Queue<T> implements Serializable{

	private Node head;
	private Node end;
	
	public Queue() {
		this.head = null;
		this.end = null;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getEnd() {
		return end;
	}

	public void setEnd(Node end) {
		this.end = end;
	}
	
	public boolean isEmpty() {
		return  head == null;
	}
	
	public int size() {
		if(isEmpty()) {
			return 0;
		}
		Node current = head;
		int contador = 0;
		while(current != end) {
			current = current.getNext();
			contador ++;
		}
		return contador;
	}
	
	public T getFrontElement() {
		if(isEmpty()) {
			return null;
		}
		return (T) head.getData();
	}
	
	public T getRearElement() {
		if(isEmpty()) {
			return null;
		}else {
			return (T) end.getData();
		}
	}
	
	public void put(T element) {
		Node nodo = new Node(element);
		Node current = head;
		if(isEmpty()) {
			this.head = nodo;
			this.end = nodo;
		}else {
			while(current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(nodo);
			end = nodo;
		}
	}
	
	public T remove() {
		if(isEmpty()) {
			return null;
		}else {
			T element = (T) head.getData();
			head =head.getNext();
			return element;	
		}
	}
	
	public String toString() {
		String message = "[";
		Node current = this.head;
		while(current != end) {
			message +=  current.getData() + ", ";
			current = current.getNext();
		}
		message += current.getData() + "]";
		return message;
	}
	
}
