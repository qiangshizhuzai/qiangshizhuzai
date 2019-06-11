package stackPushPopOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class StackPushPopOrder {

	public boolean IsPopOrder(int[] pushA, int[] popA) {
		boolean isPopOrderOrNot = true;
		ArrayList<Integer> pushArray = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < pushA.length; i++) {
			pushArray.add(pushA[i]);
		}
		System.out.println("pushArray = " + pushArray.toString());
        if (pushA.length == 0 || popA.length == 0 || pushA == null || popA == null || (pushA.length - popA.length != 0)) {
			isPopOrderOrNot = false;
		}
        
		for (int i = 0; i < popA.length; i++) {
			System.out.println("popA = " + popA[i]);
			if (pushArray.contains(popA[i])) {
				int index = pushArray.indexOf(popA[i]);
				System.out.println("index = " + index);
				if (pushArray.containsAll(pushArray.subList(0, index + 1))) {
					for (int j = 0; j <= index; j++) {
						stack.push(pushArray.get(j));
						System.out.println("stack = " + Arrays.toString(stack.toArray()));
					}
					pushArray.removeAll(pushArray.subList(0, index + 1));
					System.out.println(pushArray);
				}
				stack.pop();
				System.out.println(Arrays.toString(stack.toArray()));
			}
			/* 若此处不加stack不为空的条件，则像pushA = {1}，popA = {2}的情况，
			 * 运行无法通过，会出现java.util.EmptyStackException的运行时异常 
			 */
			else if (!stack.isEmpty() && stack.peek() == popA[i]) {    
				stack.pop();
				System.out.println(Arrays.toString(stack.toArray()));
			} else {
				isPopOrderOrNot = false;
				break;
			}
		}
		return isPopOrderOrNot;
	}
	
	public static void main(String[] args) {
		StackPushPopOrder stackPushPopOrder = new StackPushPopOrder();
		Scanner scanner = new Scanner(System.in);
		int[] pushA = new int[1];
		int[] popA = new int[1];
		
		for (int i = 0; i < pushA.length; i++) {
			pushA[i] = scanner.nextInt();
		}
		for (int i = 0; i < popA.length; i++) {
			popA[i] = scanner.nextInt();
		}
		scanner.close();
		System.out.println("pushA = " + Arrays.toString(pushA));
		System.out.println("popA = " + Arrays.toString(popA));
		System.out.println(stackPushPopOrder.IsPopOrder(pushA, popA));
	}
}
