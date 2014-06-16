
public class StackAndQueueTester<E> {
	public static void main(String[] args) {
	Stack<String> stack = new Stack<String>();
	Queue<String> queue = new Queue<String>();
	
	stack.push("Jordan");
	stack.push("Richard");
	stack.push("Tyler");
	stack.push("Jae");
	System.out.println("Expected: [Jae, Tyler, Richard, Jordan]");
	System.out.println(stack);
	System.out.println("Expected: Jae");
	System.out.println(stack.pop());
	System.out.println("Expected: [Tyler, Richard, Jordan]");
	System.out.println(stack);
	System.out.println("Expected: Tyler");
	System.out.println(stack.peek());
	System.out.println("Expected: [Tyler, Richard, Jordan]");
	System.out.println(stack);
	System.out.println();
	System.out.println();
	
	queue.enqueue("Jordan");
	queue.enqueue("Richard");
	queue.enqueue("Tyler");
	queue.enqueue("Jae");
	System.out.println("Expected: [Jordan, Richard, Tyler, Jae]");
	System.out.println(queue);
	System.out.println("Expected: Jordan");
	System.out.println(queue.dequeue());
	System.out.println("Expected: [Richard, Tyler, Jae]");
	System.out.println(queue);
	System.out.println("Expected: Richard");
	System.out.println(queue.peek());
	System.out.println("Expected: [Richard, Tyler, Jae]");
	System.out.println(queue);
	
	
	}
}
