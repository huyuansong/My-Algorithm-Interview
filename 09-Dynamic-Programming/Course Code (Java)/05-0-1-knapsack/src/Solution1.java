import java.util.Arrays;

/// 背包问题
/// 记忆化搜索
/// 时间复杂度: O(n * C) 其中n为物品个数; C为背包容积
/// 空间复杂度: O(n * C)
public class Solution1 {

    private int[][] memo;

    public int knapsack01(int[] w, int[] v, int C) {

        if (w == null || v == null || w.length != v.length)
            throw new IllegalArgumentException("Invalid w or v");

        if (C < 0)
            throw new IllegalArgumentException("C must be greater or equal to zero.");

        int n = w.length;
        if (n == 0 || C == 0)
            return 0;

        memo = new int[n][C + 1];
        Arrays.fill(memo, -1);
        return bestValue(w, v, n - 1, C);
    }

    // 用 [0...index]的物品,填充容积为c的背包的最大价值
    private int bestValue(int[] w, int[] v, int index, int c) {

        if (c <= 0 || index < 0)
            return 0;

        if (memo[index][c] != -1) {
            //System.out.format("使用了缓存数据memo[%d][%d]=%d \n", index, c, memo[index][c]);
            return memo[index][c];
        }

        int res = bestValue(w, v, index - 1, c);
        if (c >= w[index]) // 容量还够容纳
            res = Math.max(res, v[index] + bestValue(w, v, index - 1, c - w[index]));

        return memo[index][c] = res; // 将 res 赋值并返回
    }

    public static void main(String[] args) {
        int[] w = {5, 3, 1, 6, 2, 9};
        int[] v = {10, 6, 2, 1, 5, 13};
        int C = 30;
        int res = new Solution1().knapsack01(w, v, C);
        System.out.println(res);
    }

}
