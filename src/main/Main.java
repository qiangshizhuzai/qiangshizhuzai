package main;

import java.util.Scanner;

public class Main {

	public static int minNum(int[][] matrix) {
		int minNumber = 0;
		// 先考虑主对角线
		for (int i = 1; i < matrix.length; i++) {
			for (int j = i; j < matrix[0].length - 1; j++) {
				
			}
		}
		return minNumber;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] matrix = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = in.nextInt();
			}
		}
		
		in.close();
		int output = minNum(matrix);
		System.out.println(output);
	}

}
