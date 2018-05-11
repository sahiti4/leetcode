package easy;

import java.util.*;

public class MinStack {
	Stack<Integer> stack;
	Queue<Integer> queue;

	public MinStack() {
		stack = new Stack<>();
		queue = new PriorityQueue<>();
	}

	public void push(int x) {
		stack.push(x);
		queue.add(x);
	}

	public void pop() {
		int temp = stack.pop();
		if (temp == queue.peek())
			queue.poll();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return queue.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
