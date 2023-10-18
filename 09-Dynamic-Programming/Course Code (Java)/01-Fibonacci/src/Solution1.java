// 递归求斐波那契数列
public class Solution1 {

    private int num = 0;

    public int fib( int n ){

        System.out.println("fin()新执行了 1 次，当前的 n=" + n + " 当前 num=" +  ++num + " ");

        if( n == 0 )
            return 0;

        if( n == 1 )
            return 1;

        return fib(n-1) + fib(n-2);
    }

    public int getNum(){
        return num;
    }

    public static void main(String[] args) {

        int n = 10;

        Solution1 solution = new Solution1();
        long startTime = System.currentTimeMillis();
        int res = solution.fib(n);
        long endTime = System.currentTimeMillis();

        System.out.println("fib(" + n + ") = " + res);
        System.out.println("time : " + (endTime - startTime) + " ms");
        System.out.println("run function fib() " + solution.getNum() + " times.");
    }
}
