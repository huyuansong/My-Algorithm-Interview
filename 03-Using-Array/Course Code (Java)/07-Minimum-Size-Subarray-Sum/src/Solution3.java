// 209. Minimum Size Subarray Sum
// https://leetcode.com/problems/minimum-size-subarray-sum/description/
/**
 *  给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
   抓关键字：连续子数组！！！ 题中要求（连续），所以就可以使用滑动窗口，满足题意
 */
// 时间复杂度: O(n)
// 空间复杂度: O(1)
public class Solution3 {

    public int minSubArrayLen(int s, int[] nums) {

        if(s <= 0 || nums == null)
            throw new IllegalArgumentException(" Illegal Arguments");

        int l = 0 , r = -1; // nums[l...r]为我们的滑动窗口
        int sum = 0;
        int res = nums.length + 1; // 初始为一个不可能的值

        while(l < nums.length){   // 窗口的左边界在数组范围内,使得命题[l...r]有意义，则循环继续

            if(r + 1 < nums.length && sum < s) // 因为下面 r 要右移(++r),所以这里要保证(r+1有意义)
                sum += nums[++r];
            else // r已经到头 或者 sum >= s
                sum -= nums[l++];

            if(sum >= s)
                res = Math.min(res, r - l + 1); // 因为[l,r]闭区间，所以长度为 r-l + 1
        }

        // 依旧为不可能的最大值，没有被更改过
        if(res == nums.length + 1)
            return 0;
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
        System.out.println((new Solution3()).minSubArrayLen(s, nums));
    }
}
