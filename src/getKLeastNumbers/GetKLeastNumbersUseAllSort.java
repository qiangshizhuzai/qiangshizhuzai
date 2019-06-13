package getKLeastNumbers;

import java.util.ArrayList;
import java.util.Scanner;

public class GetKLeastNumbersUseAllSort {

	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (input == null || input.length <= 0 || input.length < k) {
			return arrayList;
		}
        
        sort(input);
        for (int i = 0; i < k; i++) {
			arrayList.add(input[i]);
		}
        return arrayList;
    }
	
	public void sort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int j;
			int insertNum = array[i];
			for (j = i - 1; j >= 0; j--) {
				if (array[j] > insertNum) {
					array[j + 1] = array[j];
				}else {
					break;
				}
			}
			array[j + 1] = insertNum;
		}
		//System.out.println(Arrays.toString(array));
	}
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[] input = new int[n];
		
		for (int i = 0; i < input.length; i++) {
			input[i] = scanner.nextInt();
		}
		scanner.close();
		GetKLeastNumbersUseAllSort getKLeastNumbersUseSort = new GetKLeastNumbersUseAllSort();
		System.out.println(getKLeastNumbersUseSort.GetLeastNumbers_Solution(input, k));
		
	}

}
