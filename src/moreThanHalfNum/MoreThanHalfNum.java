package moreThanHalfNum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MoreThanHalfNum {

	public int MoreThanHalfNum_Solution(int [] array) {
        int outputNum = 0;
        if (array == null || array.length <= 0) {
			return 0;
		}
        Map<Integer, Integer>  map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
			if (! map.containsKey(array[i])) {
				map.put(array[i], 1);
			}else {
				map.put(array[i], map.get(array[i]) + 1);
			}
		}
        
        for (int i : map.keySet() ) {
			if (map.get(i) > array.length / 2) {
				outputNum = i;
			}
		}
        return outputNum;
    }
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] inputArray = new int[n];
		for (int i = 0; i < inputArray.length; i++) {
			inputArray[i] = scanner.nextInt();
		}
		scanner.close();
		MoreThanHalfNum moreThanHalfNum = new MoreThanHalfNum();
		System.out.println(moreThanHalfNum.MoreThanHalfNum_Solution(inputArray));;

	}

}

