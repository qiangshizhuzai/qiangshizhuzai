package minFunctionOfTheStack;

import java.util.Stack;

public class MinFunctionOfTheStack {

	Stack<Integer> stack = new Stack<>();
	public void push(int node) {
		stack.push(node);
	}
	
	public void pop() {
		stack.pop();
	}
	
	public int top() {
		return stack.peek();
	}
	
	public int min() {
		int minNumOfTheStack = stack.peek();
		int temp = 0;
		while (stack.iterator().hasNext()) {
			temp = stack.iterator().next();
			if (temp < minNumOfTheStack) {
				minNumOfTheStack = temp;
			}
		}
		return minNumOfTheStack;
	}
}
