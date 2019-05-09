package sortOddAndEvenNumberInArrayUseStack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class SortOddAndEvenNumberInArray {
	
	public static void sort(int[] array) {
		
		Stack<Integer> stack1 = new Stack<>(); // ���ż��
		Stack<Integer> stack2 = new Stack<>(); // �������
		stack1.clear();
		stack2.clear();
/*		System.out.println(Arrays.toString(stack1.toArray()));
		System.out.println(Arrays.toString(stack2.toArray()));
*/		if (array.length > 0) {
	
			for (int i = array.length - 1; i >= 0; i--) {
				if (array[i] % 2 == 0) {
					stack1.push(array[i]);
				}else {
					stack2.push(array[i]);
				}
			}
			int length = stack2.size(); 
			// �˴��ǹؼ���stack.size()�Ǳ���������stack2��ջ����ʱ�̱仯���ʲ�����Ϊforѭ�����ж����
/*			System.out.println("stack2.zize() = " + stack2.size());
			System.out.println(Arrays.toString(stack1.toArray()));
			System.out.println(Arrays.toString(stack2.toArray()));
*/
			try {
				if (!stack2.isEmpty()) {
					for (int i = 0; i < length; i++) {
						array[i] = stack2.pop();
					 // System.out.println(Arrays.toString(stack2.toArray()));
					}
				}
		
/*			System.out.println(Arrays.toString(newArray));
			System.out.println("length = " + length);
*/			
				if (!stack1.isEmpty()) {
					for (int i = length; i < array.length; i++) {
						array[i] = stack1.pop();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
		}
		scanner.close();
		sort(array);
		System.out.println(Arrays.toString(array));

	}

}
