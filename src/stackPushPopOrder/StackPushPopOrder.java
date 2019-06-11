package stackPushPopOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class StackPushPopOrder {

	public boolean IsPopOrder(int[] pushA, int[] popA) {
		boolean isPopOrderOrNot = true;
		ArrayList<Integer> pushArray = new ArrayList<>();// 存放未入栈元素
		Stack<Integer> stack = new Stack<>();
		
		// 将压栈数组中的所有元素按照入栈顺序存入动态数组pushArray中
		for (int i = 0; i < pushA.length; i++) {
			pushArray.add(pushA[i]);
		}
		// System.out.println("pushArray = " + pushArray.toString());
		
		// 空数组、空引用或pushA和popA长度不等时，均说明popA不是出栈序列，返回false
        if (pushA.length == 0 || popA.length == 0 || pushA == null 
        		|| popA == null || (pushA.length - popA.length != 0)) {
			isPopOrderOrNot = false;
		}
        
        /* 对每一个出栈元素，先判断它是否还在pushArray中未压入栈；
         * 1.若该出栈元素未压入栈，寻找其在pushArray中的index，则按入栈序列中的顺序，将该元素及它前面
         *   的元素均依次入栈,然后从pushArray中全部移除这些元素,最后将该元素从栈顶出栈；
         * 2.若该出栈元素已经已经压入栈，栈不为空且栈顶元素和出栈元素相等，则栈顶元素出栈；
         * 3.若该出栈元素已经压入栈且不在栈顶，则该出栈元素不能直接出栈，该出栈序列不可能是入栈序列的出栈序列，
         *   break终止当前循环，并返回false。
         */
		for (int i = 0; i < popA.length; i++) {
			System.out.println("popA = " + popA[i]);
			if (pushArray.contains(popA[i])) {
				int index = pushArray.indexOf(popA[i]);
				// System.out.println("index = " + index);
				if (pushArray.containsAll(pushArray.subList(0, index + 1))) {
					for (int j = 0; j <= index; j++) {
						stack.push(pushArray.get(j));
						//System.out.println("stack = " + Arrays.toString(stack.toArray()));
					}
					pushArray.removeAll(pushArray.subList(0, index + 1));
					// System.out.println(pushArray);
				}
				stack.pop();
				// System.out.println(Arrays.toString(stack.toArray()));
			}
			/* 若此处不加stack不为空的条件，则像pushA = {1}，popA = {2}的情况，
			 * 运行无法通过，会出现java.util.EmptyStackException的运行时异常 
			 */
			else if (!stack.isEmpty() && stack.peek() == popA[i]) {    
				stack.pop();
				// System.out.println(Arrays.toString(stack.toArray()));
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
		int n = scanner.nextInt();
		int[] pushA = new int[n];
		int[] popA = new int[n];
		
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
