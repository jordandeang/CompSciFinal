package battle;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class MyLinkedList<Command> {

	private MyLinkedListNode<Command> head;
	private MyLinkedListNode<Command> tail;
	private int size;
	public boolean add(Command arg0) {
		add(size(), arg0);
		return false;
	}
	private class MyIterator<Command> implements Iterator<Command> {
		private int iterCounter;

		public boolean hasNext() {	
			return (iterCounter < size());
		}

		public Command next() {
			iterCounter++;
			return (Command) get(iterCounter - 1);
		}

		public void remove() {
			MyLinkedList.this.remove(iterCounter - 1);
		}
	}

	public void add(int arg0, Command arg1) {
		MyLinkedListNode<Command> newNode = new MyLinkedListNode<Command>(arg1);
		if (arg0 < size()) {
			if (arg0 == 0) {
				if (size() == 0){
					head = newNode;
					tail = newNode;
				}
				else {
					newNode.setNext(head.getNext());
					head = newNode;
				}
			} else {
				MyLinkedListNode<Command> temp = head;
				for(int i = 0; i < arg0; i++){
					temp = temp.getNext();
				}
				if(temp != null){
					if(temp.getNext() != null){
						newNode.setPrevious(temp);
						newNode.setNext(temp.getNext());
						temp.getNext().setPrevious(newNode);
						temp.setNext(newNode);
					}
				}
				if(arg0 == size()-1){
					tail = newNode;
				}
			}
		}
		else if(arg0 == size() && size() > 0){
			tail.setNext(newNode);
			newNode.setPrevious(tail);
			tail = newNode;
		}else if(size() == 0){
			head = newNode;
			tail = newNode;
		}
		size++;

	}

	
	public Command get(int arg0) {
		MyLinkedListNode<Command> temp = head;
		for (int i = 0; i < arg0; i++) {
			if(temp != null)
				temp = temp.getNext();
		}
		if(temp != null)
			return temp.getData();
		return null;
	}

	public int indexOf(Command arg0) {
		for(int i = 0; i < size(); i++){
			if(get(i).equals(arg0)){
				return i;
			}
		}
		return 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public Iterator<Command> iterator() {
		return new MyIterator<Command>();
	}


	public boolean remove(Command arg0) {
		for(int i = 0; i < size(); i++){
			if(get(i).equals(arg0))
				remove(i);
		}
		return false;
	}

	public Command remove(int arg0) {
		if(arg0 == 0){
			if(size() == 0)
				head = null;
			else{
				head.getNext().setPrevious(null);
				head = head.getNext();
			}
		}
		if(arg0 < size()){
			MyLinkedListNode<Command> temp = head;
			for(int i = 0; i < arg0; i++){
				temp = temp.getNext();
			}
			if(temp.getNext() != null){
				temp.getNext().setPrevious(temp.getPrevious());
				temp.getPrevious().setNext(temp.getNext());
			}
			else{
				temp.getPrevious().setNext(null);
				tail = temp.getPrevious();
			}
		}
		size --;
		return null;
	}



	public Command set(int arg0, Command arg1) {
		if(arg0 < size()){
			MyLinkedListNode<Command> temp = head;
			for(int i = 0; i < arg0; i++){
				temp = temp.getNext();
			}
			temp.setData(arg1);
		}
		return null;
	}

	public int size() {
		return size;
	}

	
	public String toString(){
		String temp = "[";
		MyLinkedListNode<Command> tempNode = head;
		for(int i = 0; i < size() - 1; i++){
			temp += tempNode.getData().toString();
			temp += ", ";
			tempNode = tempNode.getNext();
		}
		temp += tail.getData().toString();
		temp += "]";
		return temp;
	}

	
	
}
