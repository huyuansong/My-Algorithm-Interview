import java.util.HashSet;

// 219. Contains Duplicate II
// https://leetcode.com/problems/contains-duplicate-ii/description/

/**
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，
 * 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 */

/**
 * 滑动窗口和查找表的结合使用，在数组中做滑动窗口，将 HashSet 作为查找表维护 K 个元素，判断是否有相等的元素
 */
// 时间复杂度: O(n)
// 空间复杂度: O(k)
public class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if(nums == null || nums.length <= 1)
            return false;

        if(k <= 0)
            return false;

        HashSet<Integer> record = new HashSet<Integer>();
        for(int i = 0 ; i < nums.length; i ++){
            // 在添加新元素之前，先查找是否有满足目标的情况出现，退出条件
            // 这种写法在很多地方都有，递归中也有类似的思想
            if(record.contains(nums[i]))
                return true;
            record.add(nums[i]); // 能执行到这，已经不包含了，所以加入查找表

            // 循环内部，这里维护一个 k 长的滑动窗口
            if(record.size() == k + 1)
                record.remove(nums[i-k]); // 移除掉最先加进去的那个元素，虽然record无序，但是数组有序，知道该移除谁
        }

        return false;
    }

    private static void printBool(boolean b){
        System.out.println(b ? "True" : "False");
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 1};
        int k = 1;
        printBool((new Solution()).containsNearbyDuplicate(nums, k));
    }
}
