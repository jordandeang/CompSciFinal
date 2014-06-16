package battle;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class MyLinkedList<E> implements List<E> {

	private MyLinkedListNode<E> head;
	private MyLinkedListNode<E> tail;
	private int size;
	@Override
	public boolean add(E arg0) {
		add(size(), arg0);
		return false;
	}
	private class MyIterator<E> implements Iterator<E> {
		private int iterCounter;

		public boolean hasNext() {	
			return (iterCounter < size());
		}

		public E next() {
			iterCounter++;
			return (E) get(iterCounter - 1);
		}

		public void remove() {
			MyLinkedList.this.remove(iterCounter - 1);
		}
	}

	@Override
	public void add(int arg0, E arg1) {
		MyLinkedListNode<E> newNode = new MyLinkedListNode<E>(arg1);
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
				MyLinkedListNode<E> temp = head;
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

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		for(E o:arg0){
			add(o);
		}
		return false;
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends E> arg1) {
		
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int arg0) {
		MyLinkedListNode<E> temp = head;
		for (int i = 0; i < arg0; i++) {
			if(temp != null)
				temp = temp.getNext();
		}
		if(temp != null)
			return temp.getData();
		return null;
	}

	@Override
	public int indexOf(Object arg0) {
		for(int i = 0; i < size(); i++){
			if(get(i).equals(arg0)){
				return i;
			}
		}
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new MyIterator<E>();
	}

	@Override
	public int lastIndexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		for(int i = 0; i < size(); i++){
			if(get(i).equals(arg0))
				remove(i);
		}
		return false;
	}

	@Override
	public E remove(int arg0) {
		if(arg0 == 0){
			if(size() == 0)
				head = null;
			else{
				head.getNext().setPrevious(null);
				head = head.getNext();
			}
		}
		if(arg0 < size()){
			MyLinkedListNode<E> temp = head;
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

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E set(int arg0, E arg1) {
		if(arg0 < size()){
			MyLinkedListNode<E> temp = head;
			for(int i = 0; i < arg0; i++){
				temp = temp.getNext();
			}
			temp.setData(arg1);
		}
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public List<E> subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString(){
		String temp = "[";
		MyLinkedListNode<E> tempNode = head;
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
