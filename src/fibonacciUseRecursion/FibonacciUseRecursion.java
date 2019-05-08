package fibonacciUseRecursion;

public class FibonacciUseRecursion {

	public int Fibonacci(int n) {
		 
        int result = 0;
        if(n == 0){
            result = 0;
        }else if(n == 1 || n == 2){
            result = 1;
        }else if(n >= 3 && n <= 39){
            result = Fibonacci(n - 1) + Fibonacci(n - 2);
        }else{
            System.out.println("输入非法！！！请重新输入n值");
        }
        return result;
    }
}
