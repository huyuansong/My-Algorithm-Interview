import java.util.Arrays;

/// 198. House Robber
/// https://leetcode.com/problems/house-robber/description/
/// 记忆化搜索, 优化状态转移
/// 时间复杂度: O(n)
/// 空间复杂度: O(n)
public class Solution1Update {

    // memo[i] 表示考虑抢劫 nums[i...n) 所能获得的最大收益
    private int[] memo;

    public int rob(int[] nums) {

        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return tryRob(nums, 0);
    }

    // 考虑抢劫nums[index...n)这个范围的所有房子
    private int tryRob(int[] nums, int index) {

        if (index >= nums.length)
            return 0;

        if (memo[index] != -1) {
            System.out.println("缓存的值memo[" + index + "]=" + memo[index] + "被复用了" );
            return memo[index];
        }

        // 或者当前房子放弃, 从下一个房子开始考虑
        // 或者抢劫当前的房子, 从i+2以后的房子开始考虑
        memo[index] =
                Math.max(tryRob(nums, index + 1),
                        nums[index] + tryRob(nums, index + 2)); // 后一个 tryRob 会使用前一个 tryRob 缓存的值

        System.out.println("memo[" + index + "]=" + memo[index] + "缓存了");

        return memo[index];

    }

    public static void main(String[] args) {

        int nums[] = {2, 1, 4, 3};
        System.out.println((new Solution1Update()).rob(nums));
    }
}
