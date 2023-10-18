// 209. Minimum Size Subarray Sum
// https://leetcode.com/problems/minimum-size-subarray-sum/description/
/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 */
// 暴力解法
// 该方法在 LeetCode 中会超时！
// 时间复杂度: O(n^3)
// 空间复杂度: O(1)
public class Solution1 {

    public int minSubArrayLen(int s, int[] nums) {

        if(s <= 0 || nums == null)
            throw new IllegalArgumentException("Illegal Arguments");

        int res = nums.length + 1;
        //在[l,r]之间寻找一个区间，要使得命题有意义，则r的取值范围是 [l,nums.length],最少为1个元素
        // 在写具体的代码之前把这段代码要完成的任务写清楚，然后代码中不断地维护定义
        for(int l = 0 ; l < nums.length ; l ++)
            for(int r = l ; r < nums.length ; r ++){ // [l,r]最小有 1 个元素，那么 min(r)=l
                int sum = 0;
                for(int i = l ; i <= r ; i ++)
                    sum += nums[i];
                if(sum >= s)
                    res = Math.min(res, r - l + 1);
            }

        if(res == nums.length + 1)
            return 0;

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
        System.out.println((new Solution1()).minSubArrayLen(s, nums));
    }
}
