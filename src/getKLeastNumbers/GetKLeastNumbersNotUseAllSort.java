package getKLeastNumbers;

import java.util.ArrayList;
import java.util.Scanner;

public class GetKLeastNumbersNotUseAllSort {

	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k){
		ArrayList<Integer> arrayList = new ArrayList<>();
		// 注意此处的特殊输入测试的完整性，尤其是k<= 0的情况
		if (input == null || input.length <= 0 || input.length < k || k <= 0 ) {
			return arrayList;
		}
		int[] subInput = new int[k];
		for (int i = 0; i < k; i++) {
			subInput[i] = input[i];
		}
		//System.out.println(Arrays.toString(subInput));
		sort(subInput);
		//System.out.println(Arrays.toString(subInput));
		
		for (int i = k; i < input.length; i++) {
			//System.out.println("input[i] = " + input[i]);
			if (input[i] <= subInput[0]) {
				if (subInput.length == 1) {
					subInput[0] = input[i];
				}else {
					for (int j = subInput.length - 2; j >= 0; j--) {
						subInput[j  + 1] = subInput[j];
					}
					subInput[0] = input[i];
					//System.out.println(Arrays.toString(subInput));
				}
				
			}else if (input[i] > subInput[0] && input[i] < subInput[k - 1]) {
				int j;
				
				for (j = 0; j < subInput.length - 1; j++) {
					if (input[i] >= subInput[j] && input[i] <= subInput[j + 1]) {
						
						break;
					}
				}
				System.out.println("j = " + j);
				for (int l = subInput.length - 2; l >= j + 1 ; l--) {
					subInput[l + 1] = subInput[l];
					//System.out.println(Arrays.toString(subInput));
				}
				subInput[j + 1] = input[i];
				//System.out.println(Arrays.toString(subInput));
			}
			
			
		}
		for (int j = 0; j < subInput.length; j++) {
			arrayList.add(subInput[j]);
		}
		//System.out.println(arrayList);
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
		GetKLeastNumbersNotUseAllSort getKLeastNumbersNotUseAllSort = new GetKLeastNumbersNotUseAllSort();
		System.out.println(getKLeastNumbersNotUseAllSort.GetLeastNumbers_Solution(input, k));
		
	}
}
