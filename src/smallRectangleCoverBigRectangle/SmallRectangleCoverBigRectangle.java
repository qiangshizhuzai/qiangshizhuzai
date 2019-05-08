package smallRectangleCoverBigRectangle;

public class SmallRectangleCoverBigRectangle {

	public int RectCover(int target) {

		int methodNumber = 0;
		if (target == 0) {
			methodNumber = 0;
		}else if (target == 1) {
			methodNumber = 1;
		}else if (target == 2) {
			methodNumber = 2;
		}else if (target > 2) {
			methodNumber = fibonacci(target - 1) + fibonacci(target - 2);
		}
		return methodNumber;
		
    }

	private int fibonacci(int i) {
		int result = 0;
		if (i == 0) {
			result = 0;
		}else if (i == 1) {
			result = 1;
		}else if (i == 2) {
			result = 2;
		}else if (i >= 3) {
			int fib1 = 1;
            int fib2 = 2;
            int fibSum = 0;
            // 使用循环计算斐波那契序列，减少重复节点计算，时间复杂度O(n)
            for(int j =3; j <= i; j ++){
                fibSum = fib1 + fib2;
                fib1 = fib2; 
                fib2 = fibSum;
            }
            result = fibSum;
		}
		return result;
	}
}
