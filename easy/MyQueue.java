package easy;

import java.util.*;

public class MyQueue {

	Stack<Integer> pushStack = null;
	Stack<Integer> popStack = null;

	/** Initialize your data structure here. */
	public MyQueue() {
		pushStack = new Stack<>();
		popStack = new Stack<>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		if (!popStack.isEmpty())
			transfer(popStack, pushStack);
		pushStack.add(x);
	}

	private void transfer(Stack<Integer> stack1, Stack<Integer> stack2) {
		while (!stack1.isEmpty()) {
			int pop = stack1.pop();
			stack2.add(pop);
		}
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		if (popStack.isEmpty())
			transfer(pushStack, popStack);
		return popStack.pop();
	}

	/** Get the front element. */
	public int peek() {
		if (popStack.isEmpty())
			transfer(pushStack, popStack);
		return popStack.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return (popStack.isEmpty() && pushStack.isEmpty());
	}
}
