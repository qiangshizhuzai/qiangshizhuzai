package minFunctionOfTheStackUseAuxiliaryStack;

import java.util.Stack;

public class MinFunctionOfTheStackUseAuxiliaryStack {

	Stack<Integer> stack = new Stack<>();
	Stack<Integer> auxiliaryMinNumStack = new Stack<>();
	
	public void push(int node) {
		stack.push(node);
		if (auxiliaryMinNumStack.size() == 0 || node < auxiliaryMinNumStack.peek()) {
			auxiliaryMinNumStack.push(node);
		}else {
			auxiliaryMinNumStack.push(auxiliaryMinNumStack.peek());
		}
	}
	
	public void pop() {
		if (stack.size() > 0 && auxiliaryMinNumStack.size() > 0) {
			stack.pop();
			auxiliaryMinNumStack.pop();
		}
	}
	
	public int top() {
		assert(stack.size() > 0 && auxiliaryMinNumStack.size() > 0) : "栈为空，无栈顶元素";
		return stack.peek();
	}
	
	public int min() {

		assert(stack.size() > 0 && auxiliaryMinNumStack.size() > 0) : "栈为空，无最小值";
		return auxiliaryMinNumStack.peek();
	}

}
