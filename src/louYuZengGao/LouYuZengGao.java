package louYuZengGao;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LouYuZengGao {
	// ������������
	public static int[] sort(int[] input) {

		for (int i = 1; i < input.length; i++) {
			int insertNum = input[i];
			int j;
			for (j = i - 1; j >= 0; j--) {
				if (input[j] > insertNum) {
					input[j + 1] = input[j];
				}else {
					break;
				}
			}
			input[j + 1] = insertNum;
		}
		return input;
	}
	
	//�������������ͬԪ�ؼ���
	public static int[] count(int[] input1) {
		Set<Integer> set = new HashSet<>();
		
		int size = 0;
		for (int i = 0; i < input1.length; i++) {
			set.add(input1[i]);
		}
		size = set.size();
		
		int[] count = new int[size];
		for (int i = 0; i < count.length; i++) {
			count[i] = 0;
		}
		
		int base = input1[0];
		int j = 0;
		for (int i = 0; i < input1.length; i++) {
			if (input1[i] == base) {
				count[j] ++;
			}else {
				j++;
				base = input1[i];
				count[j]++;
			}
		}
		return count;
	}
	
	// �ж������������Ƿ���ڴ���n����ͬԪ��
	public static boolean judgeExist(int[] input2,int n) {
		boolean flag = false;
		for (int i = 0; i < input2.length; i++) {
			if (input2[i] >= n) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	// ��������ڣ�����¥��������ѷ�����input2�������������ú�ľ���input3�����������Ԫ�ؼ�������nΪ������ͬ�߶�¥����
	public static double[] expenseArray(int[] input2,int[] input3, int n) {
		// Ѱ��n����λ��
		int temp = 0;
		int i; // input3��Ԫ���±꣬���ڼ�¼n����λ��
		for (i = 0; i < input3.length; i++) {
			temp += input3[i];
			if (temp >= n) {
				break;
			}
		}
		// ��ʼ�����۾���
		double[] expense = new double[input3.length];
		for (int j = 0; j < expense.length; j++) {
			if (j < i) {
				expense[j] = Double.POSITIVE_INFINITY;
			}else {
				expense[j] = 0;
			}
			
		}
		
		// ������۾���
		int k = i; // ���۾�����Ԫ���±�
		// ע��˴�j�Ŀ�ʼ�±�Ϊtemp - 1
		for (int j = temp - 1; j <input2.length ; ) {
			for (int j2 = temp - 1; j2 > temp - n - 1; j2--) {
				expense[k] += input2[temp - 1] - input2[j2];
			}
			i++;
			// ע���ж�i�Ƿ�Խ�磬����������ѭ��
			if (i < input3.length) {
				temp += input3[i];
				j = temp - 1;
				k++; 
			}else {
				break;
			}
		}
		return expense;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		int[] input = new int[m];
		double output = 0;
		 
		for (int i = 0; i < input.length; i++) {
			input[i] = scanner.nextInt();
		}
		scanner.close();
		
		int[] sortedInput = sort(input);
		int[] countArray = count(input);
		if (judgeExist(countArray, n)) {
			output = 0;
		}else {
			double[] expenseArray = expenseArray(sortedInput, countArray, n);
			output = expenseArray[0];
			for (int i = 1; i < expenseArray.length; i++) {
				if (expenseArray[i] < output) {
					output = expenseArray[i];
				}
			}
		}	
		System.out.println(output);
	}
}
