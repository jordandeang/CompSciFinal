package battle;

import java.util.*;

public class MyQueue {
	MyLinkedList l;

	public MyQueue() {
		l = new MyLinkedList();
	}

	public void enqueue(Command data) {
		l.add(data);
	}

	public Command dequeue() {
		Command data = (Command) l.get(l.size() - 1);
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

	public Command peek() {
		return (Command) l.get(l.size() - 1);
	}
}
