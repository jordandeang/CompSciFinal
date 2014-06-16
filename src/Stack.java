import java.util.LinkedList;


public class Stack<E> {
	LinkedList l;
	public Stack(){
		l = new LinkedList<E>();
	}
	public void push(E data){
		l.add(0,data);
	}
	
	public Object pop(){
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
			temp+=" " + l.get(i) +",";
		}
		temp += "]";
		return temp;
	}
	
	
}
