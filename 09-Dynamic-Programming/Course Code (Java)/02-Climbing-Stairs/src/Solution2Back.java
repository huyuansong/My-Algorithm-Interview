/// 70. Climbing Stairs
/// https://leetcode.com/problems/climbing-stairs/description/
/// 动态规划
/// 时间复杂度: O(n)
/// 空间复杂度: O(n)
public class Solution2Back {

    public int climbStairs(int n) {

        int[] memo = new int[n + 1];

        // 递推公式的初始值必须先写
        memo[0] = 1;
        memo[1] = 1;

        for(int i = 2 ; i <= n ; i ++){
            memo[i] = memo[i - 1] + memo[i - 2];
            System.out.printf("memo[%d]=%d \n" , i , memo[i] );
        }
        return memo[n];
    }

    public static void main(String[] args) {

        System.out.println((new Solution2Back()).climbStairs(10));
    }
}
