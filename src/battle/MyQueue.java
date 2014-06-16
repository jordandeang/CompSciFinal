package battle;

import java.util.*;

public class MyQueue<E> {
	MyLinkedList l;

	public MyQueue() {
		l = new MyLinkedList<E>();
	}

	public void enqueue(E data) {
		l.add(data);
	}

	public E dequeue() {
		E data = (E) l.get(l.size() - 1);
		l.remove(l.size() - 1);
		return data;
	}

	public String toString() {
		String hello = "[";

		for (int i = 0; i < l.size() - 1; i++) {
			hello += l.get(i).toString();
			hello += ",";

		}
		hello += l.get(l.size() - 1);
		hello += "]";
		return hello;
	}

	public E peek() {
		return (E) l.get(l.size() - 1);
	}
}
