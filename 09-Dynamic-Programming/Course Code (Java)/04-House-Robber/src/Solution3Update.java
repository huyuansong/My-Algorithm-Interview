import java.util.Arrays;

/// 198. House Robber
/// https://leetcode.com/problems/house-robber/description/
/// 记忆化搜索, 改变状态定义, 优化转移方程
/// 时间复杂度: O(n)
/// 空间复杂度: O(n)
public class Solution3Update {

    // memo[i] 表示考虑抢劫 nums[0...i] 所能获得的最大收益
    private int[] memo;

    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return tryRob(nums, nums.length - 1);
    }

    // 考虑抢劫nums[0...index]这个范围的所有房子
    private int tryRob(int[] nums, int index){

        if(index < 0)
            return 0;

        if(memo[index] != -1)
            return memo[index];

        // 或者当前房子放弃, 考虑[0...index-1]的所有房子
        // 或者抢劫当前的房子, 考虑[0...index-2]的所有房子
        // 和方案3 对比，提前缓存了数据，其实循环在递归中发生了，不过又缓存了，所以还是这个写法更快
        return memo[index] =
                Math.max(tryRob(nums, index - 1),
                         nums[index] + tryRob(nums, index - 2)); // 这个tryRob(nums, index-2) 里面的所有值都在 tryRob(nums, index-1)计算并缓存过了

        /* Solution3
        *   int res = 0;
            for(int i = 0 ; i <= index ; i ++)
            res = Math.max(res, nums[i] + tryRob(nums, i - 2));
        *
        * */

    }

    public static void main(String[] args) {

        int nums[] = {2, 1};
        System.out.println((new Solution3Update()).rob(nums));
    }
}
