package sortOddAndEvenNumberInArrayUseExchange;

import java.util.Arrays;
import java.util.Scanner;

public class SortOddAndEvenNumberInArrayUseSwapFunction {

	// 前偶后奇时就交换顺序，采用类似直接插入排序的思想
	public static void change(int[] array) {
		for (int i = 1; i < array.length ; i++) {
			if (array[i] % 2 != 0) {
				int currentNum = array[i];
				int j;
				for (j = i - 1; j >= 0; j--) {
					if (array[j] % 2 == 0 ) {
						array[j + 1] = array[j];
						
					} else {
						break;
					}
				}
				array[j + 1] = currentNum;
				//System.out.println("i = " + i +": " + Arrays.toString(array));
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
		change(array);
		System.out.println(Arrays.toString(array));

	}

}
