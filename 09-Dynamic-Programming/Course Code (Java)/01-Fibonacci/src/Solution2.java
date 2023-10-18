import java.util.Arrays;
/** // 记忆化搜索
 *  这里是深入理解递归的好案例：程序先向下调用函数，然后开始出栈回来，
 *  n = 0 时是共用的开始回溯的底，只调用了 1 次，所以递归树 向下再向上 ，共调用 2n+1 次，
 *  然而下去到 memo[1],memo[0]时，就计算出了memo[2];等回来调用 memo[1]时，已经可以计算 memo[3]
 *  所以回来的时候，只需要运行到 fib(8)时就已经可以计算 memo[10]了
 *  所以 fib 整个的调用次数是 (2n+1)-2 = 2n-1 次
 */
public class Solution2 {

    private int num = 0;
    private int count = 0;

    public int fib(int n){

        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return fib(n, memo);
    }

    private int fib(int n, int[] memo){

        System.out.println("fin()新执行了 1 次，当前的 n=" + n + " 当前 count=" + ++count + " ");

        if(n == 0){
            System.out.println("递归到底，返回了一次 n=0 ");
            return 0;
        }

        if(n == 1) {
            System.out.println("递归到底，返回了一次 n=1 ");
            return 1;
        }

        if(memo[n] == -1) {
            memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
            System.out.println("计算了 memo[" + n + "]"  + "=" + memo[n]  + " , ");
        }

        return memo[n];
    }

    public int getNum(){
        return num;
    }

    public static void main(String[] args) {

        //int n = 42;
        int n = 10; // 注意: 我们使用n = 1000只是为了测试性能, 实际上会溢出
                      // 斐波那契额数列是以指数速度上涨的

        Solution2 solution = new Solution2();
        long startTime = System.currentTimeMillis();
        int res = solution.fib(n);
        long endTime = System.currentTimeMillis();

        System.out.println("fib(" + n + ") = " + res);
        System.out.println("time : " + (endTime - startTime) + " ms");
        System.out.println("run function fib() " + solution.getNum() + " times.");
    }
}
