// 209. Minimum Size Subarray Sum
// https://leetcode.com/problems/minimum-size-subarray-sum/description/
/**
* 给定一个含有 n 个正整数的数组和一个正整数 target 。
* 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
* 如果不存在符合条件的子数组，返回 0 。
* */
// 优化暴力解 ，使用查找表存储一段元素的和，避免每次都重新累加计算 ，被称为 查找表 ，运用很灵活
// 时间复杂度: O(n^2)
// 空间复杂度: O(n)
public class Solution2 {

    public int minSubArrayLen(int s, int[] nums) {

        if(s <= 0 || nums == null)
            throw new IllegalArgumentException("Illegal Arguments");

        // 开辟一个空间，存储一段元素的和，作为查找表使用，减少每次查找。
        // sums[i]存放nums[0...i-1]的和，区间范围一定要明确清楚
        int[] sums = new int[nums.length + 1]; // nums[0,nums.length]
        sums[0] = 0; // sums[0]表示0个元素，不是索引为0的元素，所以上面要多开辟一个空间
        for(int i = 1 ; i <= nums.length ; i ++)
            sums[i] = sums[i-1] + nums[i-1]; // sums[nums.length] = sums[length-1] + nums[length-1]

        int res = nums.length + 1; // 这是一个不可能取到的值,用来初始化变量
        for(int l = 0 ; l < nums.length ; l ++)
            for(int r = l ; r < nums.length ; r ++){
                // 使用sums[r+1] - sums[l] 快速获得nums[l...r]的和
                if(sums[r+1] - sums[l] >= s)
                    res = Math.min(res, r - l + 1); // 找到了一个一个符合条件的值，看是否比之前的方案长度更小
            }

        // 如果res的值依旧是不可能的初始值，中途没有被修改过，那么没有找到更小的情况
        if(res == nums.length + 1)
            return 0;

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
        System.out.println((new Solution2()).minSubArrayLen(s, nums));
    }
}
