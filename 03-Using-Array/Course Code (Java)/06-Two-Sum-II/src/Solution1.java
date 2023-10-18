// 167. Two Sum II - Input array is sorted
// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
// 输入的数组是排序好的

/**
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，
 * 请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，
 * 则 1 <= index1 < index2 <= numbers.length 。
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * 你所设计的解决方案必须只使用常量级的额外空间。
 *
 * 示例 1：
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2]
 */
// 暴力枚举法
// 时间复杂度: O(n^2)
// 空间复杂度: O(1)
public class Solution1 {

    public int[] twoSum(int[] numbers, int target) {

        if(numbers.length < 2 /*|| !isSorted(numbers)*/)
            throw new IllegalArgumentException("Illegal argument numbers");

        for(int i = 0 ; i < numbers.length ; i ++)
            for(int j = i+1 ; j < numbers.length ; j ++)
                if(numbers[i] + numbers[j] == target){
                    int[] res = {i+1, j+1};
                    return res;
                }

        throw new IllegalStateException("The input has no solution");
    }

    private boolean isSorted(int[] numbers){
        for(int i = 1 ; i < numbers.length ; i ++)
            if(numbers[i] < numbers[i-1]) // 出现后面的元素比前面的小，则退出
                return false;
        return true;
    }

    private static void printArr(int[] nums){
        for(int num: nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 13;
        printArr((new Solution1()).twoSum(nums, target));
    }
}
