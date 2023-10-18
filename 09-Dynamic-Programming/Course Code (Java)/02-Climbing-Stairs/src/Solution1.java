import java.util.Arrays;

public class Solution1 {

    private int[] memo;

    // 解决业务需求和做辅助工作的函数
    public int climbStairs(int n) {
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        return calcWays(n);
    }

    // 处理技术逻辑的函数
    private int calcWays(int n){

        if(n == 0 || n == 1) // 这种情况下就不要再计算了，直接返回结果
            return 1;

        if(memo[n] == -1  )
            memo[n] = calcWays(n - 1) + calcWays(n - 2);

        return memo[n];
    }

    public static void main(String[] args) {

        System.out.println((new Solution1()).climbStairs(10));
    }
}
