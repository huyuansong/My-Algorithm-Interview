/// 70. Climbing Stairs
/// https://leetcode.com/problems/climbing-stairs/description/
/// 动态规划 ：既然已经从递归（自上而下）那里挖掘出了函数的执行细节，那么直接反向（自下而上）计算，省下了递归向下的过程
/// 递归能够转写为动态规划，核心在于递归的内容有重复的结构（最优子结构），和相同的中间计算结果（最小子问题）
/// 时间复杂度: O(n)
/// 空间复杂度: O(n)
public class Solution2 {

    public int climbStairs(int n) {

        int[] memo = new int[n + 1];

        // 递推公式的初始值必须先写
        memo[0] = 1;
        memo[1] = 1;

        for(int i = 2 ; i <= n ; i ++)
            memo[i] = memo[i - 1] + memo[i - 2];
        return memo[n];
    }

    public static void main(String[] args) {

        System.out.println((new Solution2()).climbStairs(10));
    }
}
