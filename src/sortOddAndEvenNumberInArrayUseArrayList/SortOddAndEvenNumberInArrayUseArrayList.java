package sortOddAndEvenNumberInArrayUseArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SortOddAndEvenNumberInArrayUseArrayList {

	public static void sort(int[] array) {
		
		ArrayList<Integer> arrayList = new ArrayList<>(); // 存放新排序数组

/*		System.out.println(Arrays.toString(stack1.toArray()));
		System.out.println(Arrays.toString(stack2.toArray()));
*/		if (array.length > 0) {
	
			for (int i = 0; i < array.length; i++) {
				if (array[i] % 2 != 0) {
					arrayList.add(array[i]);
				}
			}
			for (int i = 0; i < array.length; i++) {
				if (array[i] % 2 == 0) {
					arrayList.add(array[i]);
				}
			}

/*			System.out.println("arrayList.size() = " + arrayList.size());
			System.out.println(Arrays.toString(arrayList.toArray()));
*/
			try {
				if (!arrayList.isEmpty()) {
					for (int i = 0; i < arrayList.size(); i++) {
						array[i] = arrayList.get(i);
					}
				}
		
/*			System.out.println(Arrays.toString(array));
*/			
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
