// 209. Minimum Size Subarray Sum
// https://leetcode.com/problems/minimum-size-subarray-sum/description/
/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。
 * 如果不存在符合条件的子数组，返回 0 。
 * */
// 二分搜索
/**
 * 虽然区间不是递增的，但是区间和却是单调递增的，因为数组n个元素都是正数
*  所以区间和数组一定是一个递增的有序数组，因此可以在 区间和 数组中二分查找
* */
// 扩展 Solution2 的方法。对于每一个l, 可以使用二分搜索法搜索r
// 时间复杂度: O(nlogn)
// 空间复杂度: O(n)
public class Solution5 {

    public int minSubArrayLen(int s, int[] nums) {

        if(s <= 0 || nums == null)
            throw new IllegalArgumentException("Illigal Arguments");

        // sums[i]存放nums[0...i-1]的和
        int[] sums = new int[nums.length + 1];
        sums[0] = 0; // 根据定义：sums[i]存放nums[0...i-1]的和，这是一个特殊值
        for(int i = 1 ; i <= nums.length ; i ++)
            sums[i] = sums[i-1] + nums[i-1];

        int res = nums.length + 1; // 设置为一个业务中不可能出现的最值
        for(int l = 0 ; l < nums.length ; l ++){
            // Java类库中没有内置的lowerBound方法，
            // 我们需要自己实现一个基于二分搜索的lowerBound:)
            int r = lowerBound(sums, sums[l] + s);
            if(r != sums.length){
                res = Math.min(res, r - l); // 根据 lowerBound 的定义，返回的是大于等于的最小值，所以这里不是 r-l+1
            }
        }

        if(res == nums.length + 1)
            return 0;
        return res;
    }

    // 在有序数组nums中寻找大于等于target的最小值
    // 如果没有（nums数组中所有值都小于target），则返回nums.length
    private int lowerBound(int[] nums, int target){

        if(nums == null /*|| !isSorted(nums)*/)
            throw new IllegalArgumentException("Illegal argument nums in lowerBound.");

        int l = 0, r = nums.length; // 在nums[l...r)的范围里寻找解
        while(l != r){
            int mid = l + (r - l) / 2;
            // 因为这里不需要求==target 的值，所以就没有对应的判断
            if(nums[mid] >= target)
                r = mid;
            else
                l = mid + 1;
        }

        return l;  // 这里返回的不是==target 的值，也没有，返回的是左侧最小的值
    }

    private boolean isSorted(int[] nums){
        for(int i = 1 ; i < nums.length ; i ++)
            if(nums[i] < nums[i-1])
                return false;
        return true;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
        System.out.println((new Solution5()).minSubArrayLen(s, nums));
    }
}
