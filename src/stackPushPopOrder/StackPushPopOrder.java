package stackPushPopOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class StackPushPopOrder {

	public boolean IsPopOrder(int[] pushA, int[] popA) {
		boolean isPopOrderOrNot = true;
		ArrayList<Integer> pushArray = new ArrayList<>();// ���δ��ջԪ��
		Stack<Integer> stack = new Stack<>();
		
		// ��ѹջ�����е�����Ԫ�ذ�����ջ˳����붯̬����pushArray��
		for (int i = 0; i < pushA.length; i++) {
			pushArray.add(pushA[i]);
		}
		// System.out.println("pushArray = " + pushArray.toString());
		
		// �����顢�����û�pushA��popA���Ȳ���ʱ����˵��popA���ǳ�ջ���У�����false
        if (pushA.length == 0 || popA.length == 0 || pushA == null 
        		|| popA == null || (pushA.length - popA.length != 0)) {
			isPopOrderOrNot = false;
		}
        
        /* ��ÿһ����ջԪ�أ����ж����Ƿ���pushArray��δѹ��ջ��
         * 1.���ó�ջԪ��δѹ��ջ��Ѱ������pushArray�е�index������ջ�����е�˳�򣬽���Ԫ�ؼ���ǰ��
         *   ��Ԫ�ؾ�������ջ,Ȼ���pushArray��ȫ���Ƴ���ЩԪ��,��󽫸�Ԫ�ش�ջ����ջ��
         * 2.���ó�ջԪ���Ѿ��Ѿ�ѹ��ջ��ջ��Ϊ����ջ��Ԫ�غͳ�ջԪ����ȣ���ջ��Ԫ�س�ջ��
         * 3.���ó�ջԪ���Ѿ�ѹ��ջ�Ҳ���ջ������ó�ջԪ�ز���ֱ�ӳ�ջ���ó�ջ���в���������ջ���еĳ�ջ���У�
         *   break��ֹ��ǰѭ����������false��
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
			/* ���˴�����stack��Ϊ�յ�����������pushA = {1}��popA = {2}�������
			 * �����޷�ͨ���������java.util.EmptyStackException������ʱ�쳣 
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
