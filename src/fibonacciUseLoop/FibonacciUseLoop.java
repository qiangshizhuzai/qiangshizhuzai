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
            // ʹ��ѭ������쳲��������У������ظ��ڵ���㣬ʱ�临�Ӷ�O(n)
            for(int i =3; i <= n; i ++){
                fibSum = fib1 + fib2;
                fib1 = fib2; 
                fib2 = fibSum;
            }
            result = fibSum;
        }else{
            System.out.println("����Ƿ�����������������nֵ");
        }
        return result;
    }
}
