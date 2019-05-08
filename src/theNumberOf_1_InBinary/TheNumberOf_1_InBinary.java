package theNumberOf_1_InBinary;

import java.util.Scanner;

public class TheNumberOf_1_InBinary {

	private int numberOf_1_InBinary(int integer) {
		int number = 0;
		String binaryString= Integer.toBinaryString(integer);
		System.out.println("binaryString = " + binaryString);
		for (int i = 0; i < binaryString.length(); i++) {
			if (binaryString.charAt(i) == '1') {
				number ++;
			}
		}
		return number;
	}
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		scanner.close();
		TheNumberOf_1_InBinary theNumberOf_1_InBinary = new TheNumberOf_1_InBinary();
		int number = theNumberOf_1_InBinary.numberOf_1_InBinary(input);
		System.out.println("该整数对应的二进制补码中的1的个数为： " + number);
	}

}
