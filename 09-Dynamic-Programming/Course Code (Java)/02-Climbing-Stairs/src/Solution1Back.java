import java.util.Arrays;

public class Solution1Back {

    private int[] memo;
    int count = 0;

    // 解决业务需求和做辅助工作的函数
    public int climbStairs(int n) {
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        return calcWays(n);
    }

    // 处理技术逻辑的函数
    private int calcWays(int n){

        System.out.println("calcWays 调用了 1 次，当前是 n = " + n  + " count= " + ++count );

        // 这个必须放在最前面，否则，会导致递归树向下到底后，依旧是无效值，无法返回，进而导致越界
        if(n == 0 || n == 1){
            System.out.println("递归的结束条件，返回了 1 ");
            return 1;
        }

        /*if (n== 0 || n==1 )
            memo[0] = 1 ; memo[1] = 1; // 用这样的写法代替上方的递归结束写法也可以，但是代码风格就不够统一了*/

        if(memo[n] == -1){
            memo[n] = calcWays(n - 1) + calcWays(n - 2);
            System.out.println("此时的 memo[" + n + "] = " + memo[n] );
        }

        return memo[n];
    }

    public static void main(String[] args) {

        System.out.println((new Solution1Back()).climbStairs(10));
    }
}
