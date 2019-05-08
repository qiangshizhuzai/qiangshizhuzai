package fibonacciUseLoop;


public class FibonacciUseLoop {

	public int Fibonacci(int n) {

        int result = 0;
        if(n == 0){
            result = 0;
        }else if(n == 1 || n == 2){
            result = 1;
        }else if(n >= 3 && n <= 39){
            int fib1 = 1;
            int fib2 = 1;
            int fibSum = 0;
            // 使用循环计算斐波那契序列，减少重复节点计算，时间复杂度O(n)
            for(int i =3; i <= n; i ++){
                fibSum = fib1 + fib2;
                fib1 = fib2; 
                fib2 = fibSum;
            }
            result = fibSum;
        }else{
            System.out.println("输入非法！！！请重新输入n值");
        }
        return result;
    }
}
