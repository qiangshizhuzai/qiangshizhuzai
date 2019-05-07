package louYuZengGao;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LouYuZengGao {
	// 输入数组排序
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
	
	//排序后数组中相同元素计数
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
	
	// 判断输入数组中是否存在大于n个相同元素
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
	
	// 如果不存在，考虑楼层增高最佳方案，input2是输入矩阵排序好后的矩阵，input3是输入矩阵中元素计数矩阵，n为所需相同高度楼栋数
	public static double[] expenseArray(int[] input2,int[] input3, int n) {
		// 寻找n所在位置
		int temp = 0;
		int i; // input3中元素下标，用于记录n所在位置
		for (i = 0; i < input3.length; i++) {
			temp += input3[i];
			if (temp >= n) {
				break;
			}
		}
		// 初始化代价矩阵
		double[] expense = new double[input3.length];
		for (int j = 0; j < expense.length; j++) {
			if (j < i) {
				expense[j] = Double.POSITIVE_INFINITY;
			}else {
				expense[j] = 0;
			}
			
		}
		
		// 计算代价矩阵
		int k = i; // 代价矩阵中元素下标
		// 注意此处j的开始下标为temp - 1
		for (int j = temp - 1; j <input2.length ; ) {
			for (int j2 = temp - 1; j2 > temp - n - 1; j2--) {
				expense[k] += input2[temp - 1] - input2[j2];
			}
			i++;
			// 注意判断i是否越界，来结束整个循环
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
