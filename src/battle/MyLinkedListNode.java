package battle;

public class MyLinkedListNode<E> {
	private E data;
	private MyLinkedListNode<E> previous;
	private MyLinkedListNode<E> next;

	public MyLinkedListNode(E d, MyLinkedListNode<E> p, MyLinkedListNode<E> n){
		data = d;
		previous = p;
		next = n;
	}
	
	public MyLinkedListNode(E arg1) {
		data = arg1;
	}

	public void setPrevious(MyLinkedListNode<E> prev){
		previous = prev;
	}
	
	public MyLinkedListNode<E> getPrevious(){
		return previous;
	}
	
	public void setNext(MyLinkedListNode<E> n){
		next = n;
	}
	
	public MyLinkedListNode<E> getNext(){
		return next;
	}
	
	public E getData(){
		return data;
	}
	
	public void setData(E d){
		data = d;
	}
}
