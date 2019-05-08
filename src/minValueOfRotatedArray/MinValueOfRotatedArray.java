package minValueOfRotatedArray;

import java.util.Scanner;

public class MinValueOfRotatedArray {

	public static int minNumberInRotateArray(int[] input) {
		int minNumberOfArray = 0;
		Boolean isQuanXiangDeng = true;
		
		if (input.length == 0) {
			return 0;
		}else {
			for (int i = 1; i < input.length; i++) {
				if (input[i] != input[i - 1]) {
					isQuanXiangDeng = false;
					break;
				}
			}
		}
		
		if (isQuanXiangDeng == true) {
			minNumberOfArray = input[0];
		}else {
			for (int i = 1; i < input.length; i++) {
				if (input[i] < input[i - 1]) {
					minNumberOfArray = input[i];
					break;
				}
			}
		}
		
		return minNumberOfArray;
	} 
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int[] input = new int[m];
		for (int i = 0; i < input.length; i++) {
			input[i] = scanner.nextInt();
		}
		scanner.close();

		System.out.println(minNumberInRotateArray(input));

	}

}
