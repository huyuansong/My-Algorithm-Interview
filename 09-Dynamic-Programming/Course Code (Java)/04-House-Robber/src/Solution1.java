import java.util.Arrays;

/// 198. House Robber
/// https://leetcode.com/problems/house-robber/description/
/// 记忆化搜索
/// 时间复杂度: O(n^2)
/// 空间复杂度: O(n)
public class Solution1 {

    private int count;

    // memo[i] 表示考虑抢劫 nums[i...n) 所能获得的最大收益
    private int[] memo;

    public int rob(int[] nums) {
        count = 0;
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return tryRob(nums, 0);
    }

    // 考虑抢劫nums[index...nums.size())这个范围的所有房子
    private int tryRob(int[] nums, int index) {


        if (index >= nums.length)
            return 0;

        //这个代码写在这里是不会复用的，因为下方的调用都在 for 循环中，看后续优化
        if (memo[index] != -1) {
            System.out.println("缓存的值memo[" + index + "]=" + memo[index] + "被复用了");
            return memo[index];
        }

        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = Math.max(res, nums[i] + tryRob(nums, i + 2)); // 这么写代码，会导致不抢的for循环过的数据没有缓存，后面递归又要调用一遍
        }

        memo[index] = res;
        System.out.println("缓存了memo[" + index + "]=" + memo[index] );

        return res;
    }

    public static void main(String[] args) {

        int nums[] = {2, 1, 4, 3};
        System.out.println((new Solution1()).rob(nums));
    }
}
