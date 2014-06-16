import java.util.LinkedList;


public class Queue<E> {
	LinkedList l;
	public Queue(){
		l = new LinkedList<E>();
	}
	
	public void enqueue(E data){
		l.add(data);
	}
	
	public Object dequeue(){
		Object e = new Object();
		e = l.get(0);
		l.remove(e);
		return e;
	}
	
	public Object peek(){
		return l.get(0);
	}
	
	public String toString(){
		String temp = "[";
		for(int i = 0; i < l.size(); i++){
			temp+=l.get(i) +", ";
		}
		temp += "]";
		return temp;
	}
}
