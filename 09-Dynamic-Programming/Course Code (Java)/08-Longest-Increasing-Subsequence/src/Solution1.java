import java.util.Arrays;

/// 300. Longest Increasing Subsequence
/// https://leetcode.com/problems/longest-increasing-subsequence/description/

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 */
/// 记忆化搜索
/// 时间复杂度: O(n^2)
/// 空间复杂度: O(n)
public class Solution1 {

    private int[] memo;

    public int lengthOfLIS(int[] nums) {

        if(nums.length == 0)
            return 0;

        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        int res = 1;
        for(int i = 0 ; i < nums.length ; i ++)
            res = Math.max(res, getMaxLength(nums, i));

        return res;
    }

    // 以 nums[index] 为结尾的最长上升子序列的长度
    private int getMaxLength(int[] nums, int index){

        if(memo[index] != -1)
            return memo[index];

        int res = 1;
        for(int i = 0 ; i <= index-1 ; i ++) // 求index位置是否为上升，需要和之前的位置元素比较
            if(nums[index] > nums[i])  // 要求index位置的元素比之前位置的所有元素都要大
                res = Math.max(res, 1 + getMaxLength(nums, i));

        return memo[index] = res;
    }

    public static void main(String[] args) {

        int nums1[] = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println((new Solution1()).lengthOfLIS(nums1));
        // 4

        // ---

        int nums2[] = {4, 10, 4, 3, 8, 9};
        System.out.println((new Solution1()).lengthOfLIS(nums2));
        // 3

        // ---

        int nums3[] = {2, 2};
        System.out.println((new Solution1()).lengthOfLIS(nums3));
        // 1

        // ---

        int nums4[] = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println((new Solution1()).lengthOfLIS(nums4));
        // 6
    }
}
